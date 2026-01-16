package Projet_POO.Service.implementation;

import java.util.UUID;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Domain.Entity.ParrainageLoueur;
import Projet_POO.Domain.Enums.StatutContrat;
import Projet_POO.Domain.Enums.StatutParrainage;
import Projet_POO.Repository.ContratLocationRepository;
import Projet_POO.Repository.LoueurRepository;
import Projet_POO.Repository.ParrainageLoueurRepository;
import Projet_POO.Service.ParrainageLoueurService;

@Service
public class ParrainageLoueurServiceImpl implements ParrainageLoueurService {

    private final ParrainageLoueurRepository parrainageRepo;
    private final LoueurRepository loueurRepo;
    private final ContratLocationRepository contratRepo;

    public ParrainageLoueurServiceImpl(ParrainageLoueurRepository parrainageRepo,
                                       LoueurRepository loueurRepo,
                                       ContratLocationRepository contratRepo) {
        this.parrainageRepo = parrainageRepo;
        this.loueurRepo = loueurRepo;
        this.contratRepo = contratRepo;
    }

    @Override
    public ParrainageLoueur creerCode(Long parrainId) {
        Loueur parrain = loueurRepo.findById(parrainId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur parrain introuvable"));

        ParrainageLoueur p = new ParrainageLoueur();
        p.setParrain(parrain);
        p.setCode(UUID.randomUUID().toString());
        p.setMontantRecompense(10.0); // 💡 à adapter
        p.setStatut(StatutParrainage.EN_ATTENTE);

        return parrainageRepo.save(p);
    }

    @Override
    public ParrainageLoueur utiliserCode(String code, Long filleulId) {
        ParrainageLoueur p = parrainageRepo.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Code invalide"));

        if (p.getFilleul() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Code déjà utilisé");
        }

        Loueur filleul = loueurRepo.findById(filleulId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur filleul introuvable"));

        if (p.getParrain().getId().equals(filleulId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "On ne peut pas se parrainer soi-même");
        }

        p.setFilleul(filleul);
        p.setStatut(StatutParrainage.LIE);

        return parrainageRepo.save(p);
    }

    @Override
    public void verifierEtCrediter(Long filleulId) {

        List<ParrainageLoueur> list = parrainageRepo.findAllByFilleul_Id(filleulId);
        if (list == null || list.isEmpty()) return;

        ParrainageLoueur p = list.stream()
                .filter(x -> !x.isRecompenseVersee())
                .findFirst()
                .orElse(list.get(0));

        if (p.isRecompenseVersee()) return;

        boolean aContratTermine = contratRepo.existsByLoueurIdAndStatut(filleulId, StatutContrat.TERMINE);
        if (!aContratTermine) return;

        Loueur parrain = p.getParrain();
        parrain.setSolde(parrain.getSolde() + p.getMontantRecompense());
        loueurRepo.save(parrain);

        p.setRecompenseVersee(true);
        p.setStatut(StatutParrainage.RECOMPENSE_VERSEE);
        parrainageRepo.save(p);
    }

}

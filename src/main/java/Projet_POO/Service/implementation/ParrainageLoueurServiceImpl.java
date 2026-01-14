package Projet_POO.Service.implementation;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

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

    public ParrainageLoueurServiceImpl(
            ParrainageLoueurRepository parrainageRepo,
            LoueurRepository loueurRepo,
            ContratLocationRepository contratRepo) {
        this.parrainageRepo = parrainageRepo;
        this.loueurRepo = loueurRepo;
        this.contratRepo = contratRepo;
    }

    @Override
    public ParrainageLoueur creerCode(Long parrainId) {
        Loueur parrain = loueurRepo.findById(parrainId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur introuvable"));

        ParrainageLoueur p = new ParrainageLoueur();
        p.setParrain(parrain);
        p.setCode(UUID.randomUUID().toString());
        p.setMontantRecompense(10.0); // ex: 10€
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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur introuvable"));

        p.setFilleul(filleul);
        p.setStatut(StatutParrainage.ACCEPTER);

        return parrainageRepo.save(p);
    }

    @Override
    public void verifierEtCrediter(Long filleulId) {
        ParrainageLoueur p = parrainageRepo.findByFilleulId(filleulId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun parrainage trouvé"));

        if (p.isRecompenseVersee()) return;

        boolean aContratTermine =
                contratRepo.existsByLoueurIdAndStatut(filleulId, StatutContrat.TERMINE);

        if (!aContratTermine) return;

        Loueur parrain = p.getParrain();
        parrain.setSolde(parrain.getSolde() + p.getMontantRecompense());
        loueurRepo.save(parrain);

        p.setRecompenseVersee(true);
        p.setStatut(StatutParrainage.RECOMPENSE_VERSEE);
        parrainageRepo.save(p);
    }
}

package Projet_POO.Service.implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Entity.ParrainageAgent;
import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Domain.Enums.StatutContrat;
import Projet_POO.Domain.Enums.StatutParrainage;
import Projet_POO.Repository.AgentRepository;
import Projet_POO.Repository.ContratLocationRepository;
import Projet_POO.Repository.ParrainageAgentRepository;
import Projet_POO.Repository.VehiculeRepository;
import Projet_POO.Service.ParrainageAgentService;

@Service
public class ParrainageAgentServiceImpl implements ParrainageAgentService {

    private final ParrainageAgentRepository parrainageRepo;
    private final AgentRepository agentRepo;
    private final VehiculeRepository vehiculeRepo;
    private final ContratLocationRepository contratRepo;

    public ParrainageAgentServiceImpl(ParrainageAgentRepository parrainageRepo,
                                      AgentRepository agentRepo,
                                      VehiculeRepository vehiculeRepo,
                                      ContratLocationRepository contratRepo) {
        this.parrainageRepo = parrainageRepo;
        this.agentRepo = agentRepo;
        this.vehiculeRepo = vehiculeRepo;
        this.contratRepo = contratRepo;
    }

    @Override
    public ParrainageAgent creerCode(Long parrainId) {
        Agent parrain = agentRepo.findById(parrainId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent parrain introuvable"));

        ParrainageAgent p = new ParrainageAgent();
        p.setParrain(parrain);
        p.setCode(UUID.randomUUID().toString());
        p.setMontantRecompense(20.0);
        p.setStatut(StatutParrainage.EN_ATTENTE);

        return parrainageRepo.save(p);
    }

    @Override
    public ParrainageAgent utiliserCode(String code, Long filleulId) {
        ParrainageAgent p = parrainageRepo.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Code invalide"));

        if (p.getFilleul() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Code déjà utilisé");
        }

        Agent filleul = agentRepo.findById(filleulId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent filleul introuvable"));

        if (p.getParrain().getId().equals(filleulId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "On ne peut pas se parrainer soi-même");
        }

        p.setFilleul(filleul);
        p.setStatut(StatutParrainage.LIE);

        return parrainageRepo.save(p);
    }

    @Override
    public void verifierEtCrediter(Long filleulId) {

        // ✅ récupère tous les parrainages liés à ce filleul
        List<ParrainageAgent> list = parrainageRepo.findAllByFilleul_Id(filleulId);
        if (list == null || list.isEmpty()) return;

        // ✅ on prend le plus récent (ou celui qui n’est pas payé)
        ParrainageAgent p = list.stream()
                .filter(x -> !x.isRecompenseVersee())
                .findFirst()
                .orElse(list.get(0));

        if (p.isRecompenseVersee()) return;

        if (!vehiculeRepo.existsByAgent_Id(filleulId)) return;

        List<Vehicule> vehicules = vehiculeRepo.findByAgent_Id(filleulId);
        boolean aUnContratTermine = false;

        for (Vehicule v : vehicules) {
            if (v != null && v.getId() != null
                    && contratRepo.existsByVehiculeIdAndStatut(v.getId(), StatutContrat.TERMINE)) {
                aUnContratTermine = true;
                break;
            }
        }

        if (!aUnContratTermine) return;

        Agent parrain = p.getParrain();
        parrain.getUtilisateur().setSolde(parrain.getUtilisateur().getSolde() + p.getMontantRecompense());
        agentRepo.save(parrain);

        p.setRecompenseVersee(true);
        p.setStatut(StatutParrainage.RECOMPENSE_VERSEE);
        parrainageRepo.save(p);
    }

}

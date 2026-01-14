package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.ContratLocation;
import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Domain.Enums.StatutContrat;
import Projet_POO.Repository.ContratLocationRepository;
import Projet_POO.Repository.VehiculeRepository;
import Projet_POO.Service.ContratLocationService;
import Projet_POO.Service.ParrainageAgentService;
import Projet_POO.Service.ParrainageLoueurService;

@Service
public class ContratLocationServiceImpl implements ContratLocationService {

    private final ContratLocationRepository contratRepo;
    private final VehiculeRepository vehiculeRepo;
    private final ParrainageLoueurService parrainageLoueurService;
    private final ParrainageAgentService parrainageAgentService;

    public ContratLocationServiceImpl(ContratLocationRepository contratRepo,
                                      VehiculeRepository vehiculeRepo,
                                      ParrainageLoueurService parrainageLoueurService,
                                      ParrainageAgentService parrainageAgentService) {
        this.contratRepo = contratRepo;
        this.vehiculeRepo = vehiculeRepo;
        this.parrainageLoueurService = parrainageLoueurService;
        this.parrainageAgentService = parrainageAgentService;
    }

    @Override
    public List<ContratLocation> findAll() {
        return contratRepo.findAll();
    }

    @Override
    public ContratLocation findById(Long id) {
        return contratRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrat non trouvé"));
    }

    @Override
    public List<ContratLocation> findByLoueur(Long loueurId) {
        return contratRepo.findByLoueurId(loueurId);
    }

    @Override
    public List<ContratLocation> findByVehicule(Long vehiculeId) {
        return contratRepo.findByVehiculeId(vehiculeId);
    }

    @Override
    public ContratLocation create(ContratLocation contrat) {
        if (contrat.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'id doit être null pour créer un contrat");
        }
        return contratRepo.save(contrat);
    }

    @Override
    public ContratLocation update(Long id, ContratLocation contrat) {
        ContratLocation existing = contratRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrat non trouvé"));

        StatutContrat ancienStatut = existing.getStatut();
        StatutContrat nouveauStatut = contrat.getStatut();

        existing.setDateDebut(contrat.getDateDebut());
        existing.setDateFin(contrat.getDateFin());
        existing.setLieuPrise(contrat.getLieuPrise());
        existing.setLieuDepose(contrat.getLieuDepose());
        existing.setStatut(nouveauStatut);
        existing.setMontantTotal(contrat.getMontantTotal());

        existing.setLoueurId(contrat.getLoueurId());
        existing.setVehiculeId(contrat.getVehiculeId());
        existing.setAssuranceId(contrat.getAssuranceId());

        ContratLocation saved = contratRepo.save(existing);

        // ✅ déclenchement uniquement si on passe à TERMINE
        if (ancienStatut != StatutContrat.TERMINE && nouveauStatut == StatutContrat.TERMINE) {

            // Parrainage Loueur
            if (saved.getLoueurId() != null) {
                parrainageLoueurService.verifierEtCrediter(saved.getLoueurId());
            }

            // Parrainage Agent (via vehicule.agentId)
            if (saved.getVehiculeId() != null) {
                Vehicule v = vehiculeRepo.findById(saved.getVehiculeId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule introuvable"));

                if (v.getAgentId() != null) {
                    parrainageAgentService.verifierEtCrediter(v.getAgentId());
                }
            }
        }

        return saved;
    }

    @Override
    public void delete(Long id) {
        if (!contratRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrat non trouvé");
        }
        contratRepo.deleteById(id);
    }
}

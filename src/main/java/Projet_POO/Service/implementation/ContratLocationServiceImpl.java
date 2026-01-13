package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.ContratLocation;
import Projet_POO.Repository.ContratLocationRepository;
import Projet_POO.Service.ContratLocationService;

@Service
public class ContratLocationServiceImpl implements ContratLocationService {

    private final ContratLocationRepository contratRepo;

    public ContratLocationServiceImpl(ContratLocationRepository contratRepo) {
        this.contratRepo = contratRepo;
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

        existing.setDateDebut(contrat.getDateDebut());
        existing.setDateFin(contrat.getDateFin());
        existing.setLieuPrise(contrat.getLieuPrise());
        existing.setLieuDepose(contrat.getLieuDepose());
        existing.setStatut(contrat.getStatut());
        existing.setMontantTotal(contrat.getMontantTotal());

        // IDs liés (version simple comme tu as fait)
        existing.setLoueurId(contrat.getLoueurId());
        existing.setVehiculeId(contrat.getVehiculeId());
        existing.setAssuranceId(contrat.getAssuranceId());

        return contratRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!contratRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrat non trouvé");
        }
        contratRepo.deleteById(id);
    }
}

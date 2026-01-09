package Projet_POO.Service;

import Projet_POO.Domain.Entity.ContratLocation;
import Projet_POO.Repository.ContratLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratLocationService {

    private final ContratLocationRepository repository;

    public ContratLocationService(ContratLocationRepository repository) {
        this.repository = repository;
    }

    public ContratLocation creerContrat(ContratLocation contrat) {
        return repository.save(contrat);
    }

    public List<ContratLocation> contratsLoueur(Long loueurId) {
        return repository.findByLoueurId(loueurId);
    }

    public List<ContratLocation> tous() {
        return repository.findAll();
    }
}

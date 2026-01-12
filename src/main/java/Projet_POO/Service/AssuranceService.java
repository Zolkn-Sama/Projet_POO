package Projet_POO.Service;

import Projet_POO.Domain.Entity.Assurance;
import Projet_POO.Repository.AssuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceService {

    private final AssuranceRepository repo;

    public AssuranceService(AssuranceRepository repo) {
        this.repo = repo;
    }

    public Assurance creer(Assurance assurance) {
        return repo.save(assurance);
    }

    public List<Assurance> toutes() {
        return repo.findAll();
    }
}
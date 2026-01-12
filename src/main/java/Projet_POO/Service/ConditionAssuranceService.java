package Projet_POO.Service;

import Projet_POO.Domain.Entity.ConditionAssurance;
import Projet_POO.Repository.ConditionAssuranceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConditionAssuranceService {

    private final ConditionAssuranceRepository repository;

    public ConditionAssuranceService(ConditionAssuranceRepository repository) {
        this.repository = repository;
    }

    public ConditionAssurance sauvegarder(ConditionAssurance condition) {
        return repository.save(condition);
    }

    public List<ConditionAssurance> listerToutes() {
        return repository.findAll();
    }
}

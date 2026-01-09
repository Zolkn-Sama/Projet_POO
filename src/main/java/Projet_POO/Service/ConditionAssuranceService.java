package Projet_POO.Service;

import Projet_POO.Domain.Entity.ConditionAssurance;
import Projet_POO.Repository.ConditionAssuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionAssuranceService {

    private final ConditionAssuranceRepository conditionRepository;

    public ConditionAssuranceService(ConditionAssuranceRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    public ConditionAssurance creer(ConditionAssurance condition) {
        return conditionRepository.save(condition);
    }

    public List<ConditionAssurance> toutes() {
        return conditionRepository.findAll();
    }

    public ConditionAssurance trouverParId(Long id) {
        return conditionRepository.findById(id).orElseThrow(() -> new RuntimeException("Condition d'assurance introuvable"));
    }
}

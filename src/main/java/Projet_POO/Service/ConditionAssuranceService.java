package Projet_POO.Service;

<<<<<<< HEAD
import java.util.List;

import Projet_POO.Domain.Entity.ConditionAssurance;

public interface ConditionAssuranceService {

    List<ConditionAssurance> findAll();

    ConditionAssurance findById(Long id);

    List<ConditionAssurance> findByAssurance(Long assuranceId);

    ConditionAssurance createForAssurance(Long assuranceId, ConditionAssurance condition);

    ConditionAssurance update(Long id, ConditionAssurance condition);

    void delete(Long id);
=======
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
>>>>>>> ALEX
}

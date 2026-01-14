package Projet_POO.Service;

import Projet_POO.Domain.Entity.ConditionsAgent;
import Projet_POO.Repository.ConditionsAgentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConditionsAgentService {

    private final ConditionsAgentRepository repository;

    public ConditionsAgentService(ConditionsAgentRepository repository) {
        this.repository = repository;
    }

    public ConditionsAgent sauvegarder(ConditionsAgent condition) {
        return repository.save(condition);
    }

    public List<ConditionsAgent> listerToutes() {
        return repository.findAll();
    }
}

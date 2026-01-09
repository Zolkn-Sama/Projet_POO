package Projet_POO.Service;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Repository.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    private final AgentRepository repo;

    public AgentService(AgentRepository repo) {
        this.repo = repo;
    }

    public Agent creer(Agent agent) {
        return repo.save(agent);
    }

    public List<Agent> tous() {
        return repo.findAll();
    }
}

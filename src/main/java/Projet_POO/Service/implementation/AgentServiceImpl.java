package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Repository.AgentRepository;
import Projet_POO.Service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;

    public AgentServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Override
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Override
    public Agent findById(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent non trouvé"));
    }

    @Override
    public Agent findByEmail(String email) {
        return agentRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent non trouvé"));
    }

    @Override
    public Agent create(Agent agent) {
        agent.setId(null); // pour être sûr que ce soit bien une création
        return agentRepository.save(agent);
    }

    @Override
    public Agent update(Long id, Agent agent) {
        Agent existing = agentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent non trouvé"));

        // Champs hérités de Utilisateur
        existing.setNom(agent.getNom());
        existing.setPrenom(agent.getPrenom());
        existing.setEmail(agent.getEmail());
        existing.setPassword(agent.getPassword());
        existing.setTelephone(agent.getTelephone());
        existing.setDateNaissance(agent.getDateNaissance());
        existing.setSolde(agent.getSolde());


        return agentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!agentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent non trouvé");
        }
        agentRepository.deleteById(id);
    }
}

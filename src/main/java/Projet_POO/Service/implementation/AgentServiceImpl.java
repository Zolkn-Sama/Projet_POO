package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Entity.Utilisateur;
import Projet_POO.Repository.AgentRepository;
import Projet_POO.Repository.UtilisateurRepository;
import Projet_POO.Service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final UtilisateurRepository utilisateurRepository;

    public AgentServiceImpl(AgentRepository agentRepository, UtilisateurRepository utilisateurRepository) {
        this.agentRepository = agentRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Override
    public Agent findByUtilisateurId(Long id) {
        return agentRepository.findByUtilisateurId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent non trouvé"));
    }

    @Override
    public Agent findByUtilisateurEmail(String email) {
        return agentRepository.findByUtilisateurEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent non trouvé"));
    }

    @Override
    public Agent create(Agent agent) {
        agent.setId(null); // pour être sûr que ce soit bien une création
        return agentRepository.save(agent);
    }

    @Override
    public Agent create(long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable pour id = " + id));

        if (agentRepository.findById(id).isPresent()) {
            throw new IllegalStateException("Cet utilisateur est déjà agent (id = " + id + ")");
        }

            Agent agent = new Agent();
            agent.setUtilisateur(utilisateur);
            agent.setId(utilisateur.getId());

        return agentRepository.save(agent);
    }

    @Override
    public Agent update(Long id, Agent agent) {
        Agent existing = agentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent non trouvé"));

        // Champs hérités de Utilisateur
        existing.getUtilisateur().setNom(agent.getUtilisateur().getNom());
        existing.getUtilisateur().setPrenom(agent.getUtilisateur().getPrenom());
        existing.getUtilisateur().setEmail(agent.getUtilisateur().getEmail());
        existing.getUtilisateur().setPassword(agent.getUtilisateur().getPassword());
        existing.getUtilisateur().setTelephone(agent.getUtilisateur().getTelephone());
        existing.getUtilisateur().setDateNaissance(agent.getUtilisateur().getDateNaissance());


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

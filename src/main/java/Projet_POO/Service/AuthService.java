package Projet_POO.Service;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Domain.Entity.Utilisateur;
import Projet_POO.Repository.AgentRepository;
import Projet_POO.Repository.LoueurRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final AgentRepository agentRepository;
    private final LoueurRepository loueurRepository;

    public AuthService(AgentRepository agentRepository, LoueurRepository loueurRepository) {
        this.agentRepository = agentRepository;
        this.loueurRepository = loueurRepository;
    }

    public Utilisateur authentifier(String email, String password) {
        // 1. On cherche d'abord dans les Loueurs
        Optional<Loueur> loueur = loueurRepository.findByEmail(email);
        if (loueur.isPresent() && loueur.get().getPassword().equals(password)) {
            return loueur.get();
        }

        // 2. Si non trouvé, on cherche dans les Agents
        Optional<Agent> agent = agentRepository.findByEmail(email);
        if (agent.isPresent() && agent.get().getPassword().equals(password)) {
            return agent.get();
        }

        return null; // Identifiants invalides
    }
}
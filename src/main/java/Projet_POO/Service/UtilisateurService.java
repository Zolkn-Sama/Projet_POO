package Projet_POO.Service;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Domain.Entity.Utilisateur; // La classe parent
import Projet_POO.Repository.AgentRepository;
import Projet_POO.Repository.LoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private LoueurRepository loueurRepository;

    // Cette methode retourne un Utilisateur Agent ou loueur
    public Utilisateur recupererUtilisateurGlobal(String email) {

        // 1. Essayer de trouver dans la table Agent
        Optional<Agent> agentOpt = agentRepository.findByEmail(email);
        if (agentOpt.isPresent()) {
            return agentOpt.get(); 
        }

        // 2. Si ce n'est pas un Agent, essayer dans la table Loueur
        Optional<Loueur> loueurOpt = loueurRepository.findByEmail(email);
        if (loueurOpt.isPresent()) {
            return loueurOpt.get(); // Retourne l'objet Loueur (qui est un Utilisateur)
        }

        // 3. Si aucun des deux, lancer une erreur
        throw new RuntimeException("Aucun utilisateur trouvé avec cet email : " + email);
    }
    
    public Utilisateur recupererUtilisateurParIdEtRole(Long id, String role) {
        if ("AGENT".equals(role)) {
            // Si c'est un agent, on cherche dans la table Agent
            return agentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Agent non trouvé avec l'ID : " + id));
        } else {
            // Sinon on cherche dans la table Loueur
            return loueurRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Loueur non trouvé avec l'ID : " + id));
        }
    }

    // Mise à jour des informations utilisateur  
    public void mettreAJourInfos(Long id, String role, Utilisateur formUser) {

        Utilisateur userBdd = recupererUtilisateurParIdEtRole(id, role);


        userBdd.setTelephone(formUser.getTelephone());
        userBdd.setRue(formUser.getRue());
        userBdd.setVille(formUser.getVille());
        userBdd.setPays(formUser.getPays());




        if ("AGENT".equals(role)) {
            agentRepository.save((Projet_POO.Domain.Entity.Agent) userBdd);
        } else {
            loueurRepository.save((Projet_POO.Domain.Entity.Loueur) userBdd);
        }
    }
}

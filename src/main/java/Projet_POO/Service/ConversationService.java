package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Entity.Conversation;
import Projet_POO.Domain.Entity.Loueur;

public interface ConversationService {

    List<Conversation> findAll();

    Conversation findById(Long id);

    List<Conversation> findByAgent(Agent agent);
    
    List<Conversation> findByLoueur(Loueur loueur);

    Conversation findOrCreateBetween(Agent agent, Loueur loueur);

    Conversation create(Conversation conversation);

    Conversation update(Long id, String name);

    void delete(Long id);
}

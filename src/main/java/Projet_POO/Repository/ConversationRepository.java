package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Entity.Conversation;
import Projet_POO.Domain.Entity.Loueur;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findAll();

    Optional<Conversation> findById(Long id);

    List<Conversation> findByAgent(Agent agent);
    
    List<Conversation> findByLoueur(Loueur loueur);

    Optional<Conversation> findByAgentIdAndLoueurId(Long agentId, Long loueurId);
}

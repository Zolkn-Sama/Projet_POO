package Projet_POO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.Conversation;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
}

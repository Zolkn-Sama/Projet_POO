package Projet_POO.Repository;

import Projet_POO.Domain.Entity.NoteAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NoteAgentRepository extends JpaRepository<NoteAgent, Long> {
    List<NoteAgent> findByAgentId(Long agentId);
}


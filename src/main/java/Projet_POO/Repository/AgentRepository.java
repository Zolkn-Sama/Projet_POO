package Projet_POO.Repository;

import Projet_POO.Domain.Entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}

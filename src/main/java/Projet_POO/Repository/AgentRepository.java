package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    List<Agent> findAll();
    Optional<Agent> findById(Long id);
    Optional<Agent> findByEmail(String email);
}


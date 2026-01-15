package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.ParrainageAgent;

@Repository
public interface ParrainageAgentRepository extends JpaRepository<ParrainageAgent, Long> {
    Optional<ParrainageAgent> findByCode(String code);
    List<ParrainageAgent> findAllByFilleul_Id(Long filleulId);
}

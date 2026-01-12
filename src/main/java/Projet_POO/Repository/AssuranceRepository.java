package Projet_POO.Repository;

import Projet_POO.Domain.Entity.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssuranceRepository extends JpaRepository<Assurance, Long> {
}

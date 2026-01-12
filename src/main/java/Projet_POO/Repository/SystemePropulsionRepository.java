package Projet_POO.Repository;

import Projet_POO.Domain.Entity.SystemePropulsion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemePropulsionRepository extends JpaRepository<SystemePropulsion, Integer> {
}
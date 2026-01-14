package Projet_POO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.NoteCritere;

/**
 * Repository dédié à la gestion individuelle des critères de notation.
 */
@Repository
public interface NoteCritereRepository extends JpaRepository<NoteCritere, Long> {
}
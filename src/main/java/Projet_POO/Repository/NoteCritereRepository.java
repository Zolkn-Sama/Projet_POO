package Projet_POO.Repository;

import Projet_POO.Domain.Entity.NoteCritere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteCritereRepository extends JpaRepository<NoteCritere, Long> {
}
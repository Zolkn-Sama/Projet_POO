package Projet_POO.Repository;

import Projet_POO.Domain.Entity.NoteLoueur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteLoueurRepository extends JpaRepository<NoteLoueur, Long> {
    List<NoteLoueur> findByLoueurId(Long loueurId);
}
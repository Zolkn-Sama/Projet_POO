package Projet_POO.Repository;

import Projet_POO.Domain.Entity.Loueur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoueurRepository extends JpaRepository<Loueur, Long> {
    Optional<Loueur> findByEmailIgnoreCase(String email);
}

package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.Loueur;

@Repository
public interface LoueurRepository extends JpaRepository<Loueur, Long> {
    List<Loueur> findAll();
    Optional<Loueur> findById(Long id);
    Optional<Loueur> findByEmail(String email);
}

package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.Assurance;

@Repository
public interface AssuranceRepository extends JpaRepository<Assurance, Long> {

    List<Assurance> findAll();
    Optional<Assurance> findById(Long id);

    // optionnel si tu veux rechercher par nom
    Optional<Assurance> findByNom(String nom);
}
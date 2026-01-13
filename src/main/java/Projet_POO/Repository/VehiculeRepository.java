package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    // Exemple si tu veux une méthode custom :
    List<Vehicule> findAll();

    Optional<Vehicule> findById(long id);

    Optional<Vehicule> findByImmatriculation(String immatriculation);
}
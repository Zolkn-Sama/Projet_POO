package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Projet_POO.Domain.Entity.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    Optional<Vehicule> findByImmatriculation(String immatriculation);
    List<Vehicule> findByVilleDisponibiliteIgnoreCase(String ville);
}
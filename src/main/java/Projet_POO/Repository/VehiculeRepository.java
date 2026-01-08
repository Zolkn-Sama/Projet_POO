package Projet_POO.Repository;

import Projet_POO.Domain.Entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    Optional<Vehicule> findByImmatriculation(String immatriculation);
    List<Vehicule> findByVilleDisponibiliteIgnoreCase(String ville);
}
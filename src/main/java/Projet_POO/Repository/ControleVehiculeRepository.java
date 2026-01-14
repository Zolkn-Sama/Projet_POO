package Projet_POO.Repository;

import Projet_POO.Domain.Entity.ControleVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ControleVehiculeRepository extends JpaRepository<ControleVehicule, Long> {

    // 🟢 AJOUT : Méthode pour trouver le contrôle technique via l'ID du véhicule
    // Spring Data JPA génère automatiquement la requête SQL basée sur le nom de la méthode
    Optional<ControleVehicule> findByVehiculeId(Long vehiculeId);
}
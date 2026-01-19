package Projet_POO.Repository;

import Projet_POO.Domain.Entity.ControleVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ControleVehiculeRepository extends JpaRepository<ControleVehicule, Long> {

    Optional<ControleVehicule> findByVehiculeId(Long vehiculeId);
}

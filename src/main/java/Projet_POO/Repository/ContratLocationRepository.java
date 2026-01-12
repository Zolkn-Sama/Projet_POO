package Projet_POO.Repository;

import Projet_POO.Domain.Entity.ContratLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratLocationRepository extends JpaRepository<ContratLocation, Long> {
    List<ContratLocation> findByLoueurId(Long loueurId);
    List<ContratLocation> findByVehiculeId(Long vehiculeId);
}


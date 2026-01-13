package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.ContratLocation;

@Repository
public interface ContratLocationRepository extends JpaRepository<ContratLocation, Long> {

    List<ContratLocation> findAll();

    Optional<ContratLocation> findById(Long id);

    List<ContratLocation> findByLoueurId(Long loueurId);

    List<ContratLocation> findByVehiculeId(Long vehiculeId);
}

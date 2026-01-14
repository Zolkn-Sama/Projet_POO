package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import Projet_POO.Domain.Enums.StatutContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.ContratLocation;

@Repository
public interface ContratLocationRepository extends JpaRepository<ContratLocation, Long> {

    List<ContratLocation> findAll();

    boolean existsByLoueurIdAndStatut(Long loueurId, StatutContrat statut);
    boolean existsByVehiculeIdAndStatut(Long vehiculeId, StatutContrat statut);



    Optional<ContratLocation> findById(Long id);

    List<ContratLocation> findByLoueurId(Long loueurId);

    List<ContratLocation> findByVehiculeId(Long vehiculeId);
}

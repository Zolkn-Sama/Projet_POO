package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import Projet_POO.Domain.Entity.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    // Permet de filtrer par ville directement en base
    List<Vehicule> findByVilleDisponibiliteIgnoreCase(String ville);
    Optional<Vehicule> findByImmatriculation(String immatriculation);

    boolean existsByAgent_Id(Long agentId);
    List<Vehicule> findByAgent_Id(Long agentId);

    @Query("SELECT v.agent.id FROM Vehicule v WHERE v.id = :vehiculeId")
    Long findAgentIdByVehiculeId(@Param("vehiculeId") Long vehiculeId);

}


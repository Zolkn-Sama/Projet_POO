package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.TypeVehicule;

@Repository
public interface TypeVehiculeRepository extends JpaRepository<TypeVehicule, Long> {

    Optional<TypeVehicule> findByLibelleIgnoreCase(String libelle);

    List<TypeVehicule> findByDomaineIgnoreCase(String domaine);

    List<TypeVehicule> findByLibelleContainingIgnoreCase(String libellePart);
}

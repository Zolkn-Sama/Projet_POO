package Projet_POO.Repository;

import Projet_POO.Domain.Entity.Vehicule; // On travaille sur les véhicules
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueRepository extends JpaRepository<Vehicule, Long> {
    // Le nom ici DOIT être CatalogueRepository
}
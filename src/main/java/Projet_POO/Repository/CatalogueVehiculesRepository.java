package Projet_POO.Repository;

import Projet_POO.Domain.Entity.CatalogueVehicules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueVehiculesRepository extends JpaRepository<CatalogueVehicules, Long> {
    // Méthodes personnalisées si nécessaire
}

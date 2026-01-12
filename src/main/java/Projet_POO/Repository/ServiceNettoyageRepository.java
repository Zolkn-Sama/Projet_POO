package Projet_POO.Repository;

import Projet_POO.Domain.Entity.ServiceNettoyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceNettoyageRepository extends JpaRepository<ServiceNettoyage, Long> {
    // Permet de manipuler spécifiquement les services de nettoyage
}
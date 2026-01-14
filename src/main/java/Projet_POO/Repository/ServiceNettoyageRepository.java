package Projet_POO.Repository;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.ServiceNettoyage;

@Repository
public interface ServiceNettoyageRepository extends JpaRepository<ServiceNettoyage, Long> {
    List<ServiceNettoyage> findAll();
    Optional<ServiceNettoyage> findById(Long id);
}
=======
import Projet_POO.Domain.Entity.ServiceNettoyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceNettoyageRepository extends JpaRepository<ServiceNettoyage, Long> {
    // Permet de manipuler spécifiquement les services de nettoyage
}
>>>>>>> ALEX

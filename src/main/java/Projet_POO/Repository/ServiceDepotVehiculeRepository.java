package Projet_POO.Repository;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.ServiceDepotVehicule;

@Repository
public interface ServiceDepotVehiculeRepository extends JpaRepository<ServiceDepotVehicule, Long> {
    List<ServiceDepotVehicule> findAll();
    Optional<ServiceDepotVehicule> findById(Long id);
}
=======
import Projet_POO.Domain.Entity.ServiceDepotVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDepotVehiculeRepository extends JpaRepository<ServiceDepotVehicule, Long> {
}
>>>>>>> ALEX

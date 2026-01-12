package Projet_POO.Repository;

import Projet_POO.Domain.Entity.ServiceDepotVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDepotVehiculeRepository extends JpaRepository<ServiceDepotVehicule, Long> {
}
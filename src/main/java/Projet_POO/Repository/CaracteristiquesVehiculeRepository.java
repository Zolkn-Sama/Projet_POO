package Projet_POO.Repository;

import Projet_POO.Domain.Entity.CaracteristiquesVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CaracteristiquesVehiculeRepository extends JpaRepository<CaracteristiquesVehicule, Long> {


}
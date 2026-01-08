package Projet_POO.Repository;

import Projet_POO.Domain.Entity.TypeVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TypeVehiculeRepository extends JpaRepository<TypeVehicule, Long> {


}


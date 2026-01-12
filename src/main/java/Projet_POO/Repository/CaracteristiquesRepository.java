package Projet_POO.Repository;

import Projet_POO.Domain.Entity.CaracteristiquesVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CaracteristiquesRepository extends JpaRepository<CaracteristiquesVehicule, Long> {
    List<CaracteristiquesVehicule> findByMarqueIgnoreCase(String marque);
}

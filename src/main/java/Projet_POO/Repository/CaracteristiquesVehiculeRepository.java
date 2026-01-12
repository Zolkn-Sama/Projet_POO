package Projet_POO.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.CaracteristiquesVehicule;

@Repository
public interface CaracteristiquesVehiculeRepository extends JpaRepository<CaracteristiquesVehicule, Long> {

    List<CaracteristiquesVehicule> findByMarqueIgnoreCase(String marque);

    List<CaracteristiquesVehicule> findByModeleIgnoreCase(String modele);

    List<CaracteristiquesVehicule> findByCouleurIgnoreCase(String couleur);

    List<CaracteristiquesVehicule> findByCategoriePermisRequiseIgnoreCase(String categoriePermisRequise);

    List<CaracteristiquesVehicule> findByNbPlaces(int nbPlaces);
}

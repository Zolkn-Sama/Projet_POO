package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.CaracteristiquesVehicule;

public interface CaracteristiquesVehiculeService {

    List<CaracteristiquesVehicule> findAll();
    CaracteristiquesVehicule findById(Long id);

    List<CaracteristiquesVehicule> findByMarque(String marque);
    List<CaracteristiquesVehicule> findByModele(String modele);
    List<CaracteristiquesVehicule> findByCouleur(String couleur);
    List<CaracteristiquesVehicule> findByCategoriePermisRequise(String categoriePermisRequise);
    List<CaracteristiquesVehicule> findByNbPlaces(int nbPlaces);

    CaracteristiquesVehicule create(CaracteristiquesVehicule caracteristiquesVehicule);
    CaracteristiquesVehicule update(Long id, CaracteristiquesVehicule caracteristiquesVehicule);
    void delete(Long id);
}

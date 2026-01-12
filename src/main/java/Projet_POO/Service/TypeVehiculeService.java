package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.TypeVehicule;

public interface TypeVehiculeService {
    List<TypeVehicule> findAll();
    TypeVehicule findById(Long id);
    TypeVehicule findByLibelle(String libelle);
    List<TypeVehicule> findByDomaine(String domaine);

    TypeVehicule create(TypeVehicule typeVehicule);
    TypeVehicule update(Long id, TypeVehicule typeVehicule);
    void delete(Long id);
}

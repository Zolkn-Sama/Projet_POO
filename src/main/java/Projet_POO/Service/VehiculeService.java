package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Vehicule;

public interface VehiculeService {
    List<Vehicule> findAll();
    Vehicule findById(Long id);
    Vehicule findByImmatriculation(String immatriculation);
    List<Vehicule> findByVilleDisponibilite(String ville);
    Vehicule create(Vehicule vehicule);
    Vehicule update(Long id, Vehicule vehicule);
    void delete(Long id);
}

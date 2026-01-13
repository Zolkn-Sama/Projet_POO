package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Vehicule;

public interface VehiculeService {

    List<Vehicule> findAll();

    Vehicule findById(long id);

    Vehicule findByImmatriculation(String immatriculation);

    Vehicule create(Vehicule vehicule);

    Vehicule update(Long id, Vehicule vehicule);

    void delete(Long id);
}

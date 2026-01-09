package Projet_POO.Service;

import Projet_POO.Domain.Entity.CaracteristiquesVehicule;
import Projet_POO.Repository.CaracteristiquesVehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristiquesVehiculeService {

    private final CaracteristiquesVehiculeRepository repository;

    public CaracteristiquesVehiculeService(CaracteristiquesVehiculeRepository repository) {
        this.repository = repository;
    }

    public CaracteristiquesVehicule creer(CaracteristiquesVehicule caracteristiques) {
        return repository.save(caracteristiques);
    }

    public List<CaracteristiquesVehicule> toutes() {
        return repository.findAll();
    }

    public CaracteristiquesVehicule trouverParId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Caractéristiques véhicule introuvable"));
    }
}

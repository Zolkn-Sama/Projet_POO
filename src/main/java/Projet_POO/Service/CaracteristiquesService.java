package Projet_POO.Service;

import Projet_POO.Domain.Entity.CaracteristiquesVehicule;
import Projet_POO.Repository.CaracteristiquesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CaracteristiquesService {

    private final CaracteristiquesRepository repository;

    public CaracteristiquesService(CaracteristiquesRepository repository) {
        this.repository = repository;
    }

    public List<CaracteristiquesVehicule> findAll() {
        return repository.findAll();
    }

    public List<CaracteristiquesVehicule> findByMarque(String marque) {
        return repository.findByMarqueIgnoreCase(marque);
    }

    public CaracteristiquesVehicule sauvegarder(CaracteristiquesVehicule c) {
        return repository.save(c);
    }
}
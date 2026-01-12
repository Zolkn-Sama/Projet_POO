package Projet_POO.Service;

import Projet_POO.Domain.Entity.TypeVehicule;
import Projet_POO.Repository.TypeVehiculeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TypeVehiculeService {

    private final TypeVehiculeRepository repository;

    public TypeVehiculeService(TypeVehiculeRepository repository) {
        this.repository = repository;
    }

    public TypeVehicule sauvegarder(TypeVehicule type) {
        return repository.save(type);
    }

    public List<TypeVehicule> listerTous() {
        return repository.findAll();
    }
}
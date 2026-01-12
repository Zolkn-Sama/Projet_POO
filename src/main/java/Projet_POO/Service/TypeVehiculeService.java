package Projet_POO.Service;

import Projet_POO.Domain.Entity.TypeVehicule;
import Projet_POO.Repository.TypeVehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeVehiculeService {

    private final TypeVehiculeRepository repo;

    public TypeVehiculeService(TypeVehiculeRepository repo) {
        this.repo = repo;
    }

    public TypeVehicule creer(TypeVehicule t) {
        return repo.save(t);
    }

    public List<TypeVehicule> tous() {
        return repo.findAll();
    }
}

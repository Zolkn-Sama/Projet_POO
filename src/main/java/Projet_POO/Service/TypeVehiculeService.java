package Projet_POO.Service;

import Projet_POO.Domain.Entity.TypeVehicule;
import Projet_POO.Repository.TypeVehiculeRepository;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

=======
>>>>>>> ALEX
import java.util.List;

@Service
public class TypeVehiculeService {

<<<<<<< HEAD
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
=======
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
>>>>>>> ALEX

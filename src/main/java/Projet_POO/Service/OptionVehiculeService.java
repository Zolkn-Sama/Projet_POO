package Projet_POO.Service;

import Projet_POO.Domain.Entity.OptionVehicule;
import Projet_POO.Repository.OptionVehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionVehiculeService {
    private final OptionVehiculeRepository repo;

    public OptionVehiculeService(OptionVehiculeRepository repo) {
        this.repo = repo;
    }

    public OptionVehicule creer(OptionVehicule o) { return repo.save(o); }
    public List<OptionVehicule> tous() { return repo.findAll(); }
}

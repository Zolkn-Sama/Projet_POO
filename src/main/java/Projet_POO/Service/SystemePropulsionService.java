package Projet_POO.Service;

import Projet_POO.Domain.Entity.SystemePropulsion;
import Projet_POO.Repository.SystemePropulsionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SystemePropulsionService {

    private final SystemePropulsionRepository repository;

    public SystemePropulsionService(SystemePropulsionRepository repository) {
        this.repository = repository;
    }

    public SystemePropulsion sauvegarder(SystemePropulsion systeme) {
        return repository.save(systeme);
    }

    public List<SystemePropulsion> listerTous() {
        return repository.findAll();
    }
}
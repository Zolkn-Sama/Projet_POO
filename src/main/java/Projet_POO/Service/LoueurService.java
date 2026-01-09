package Projet_POO.Service;

import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Repository.LoueurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoueurService {

    private final LoueurRepository repo;

    public LoueurService(LoueurRepository repo) {
        this.repo = repo;
    }

    public Loueur creer(Loueur loueur) {
        return repo.save(loueur);
    }

    public List<Loueur> tous() {
        return repo.findAll();
    }

    public Loueur parId(Long id) {
        return repo.findById(id).orElse(null);
    }
}

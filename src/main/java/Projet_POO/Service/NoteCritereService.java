package Projet_POO.Service;

import Projet_POO.Domain.Entity.NoteCritere;
import Projet_POO.Repository.NoteCritereRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteCritereService {

    private final NoteCritereRepository repository;

    public NoteCritereService(NoteCritereRepository repository) {
        this.repository = repository;
    }

    public NoteCritere sauvegarder(NoteCritere critere) {
        return repository.save(critere);
    }

    public List<NoteCritere> listerTous() {
        return repository.findAll();
    }
}
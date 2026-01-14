package Projet_POO.Service;

import Projet_POO.Domain.Entity.Disponibilite;
import Projet_POO.Repository.DisponibiliteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DisponibiliteService {

    private final DisponibiliteRepository repository;

    public DisponibiliteService(DisponibiliteRepository repository) {
        this.repository = repository;
    }

    public Disponibilite enregistrer(Disponibilite disponibilite) {
        return repository.save(disponibilite);
    }

    public List<Disponibilite> listerToutes() {
        return repository.findAll();
    }
}

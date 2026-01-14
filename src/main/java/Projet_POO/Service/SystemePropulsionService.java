package Projet_POO.Service;

<<<<<<< HEAD
import java.util.List;
import Projet_POO.Domain.Entity.SystemePropulsion;

public interface SystemePropulsionService {
    List<SystemePropulsion> findAll();
    SystemePropulsion findById(Long id);
    SystemePropulsion create(SystemePropulsion systeme);
    void delete(Long id);
=======
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
>>>>>>> ALEX
}
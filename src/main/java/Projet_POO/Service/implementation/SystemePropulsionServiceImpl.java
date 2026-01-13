package Projet_POO.Service.implementation;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import Projet_POO.Domain.Entity.SystemePropulsion;
import Projet_POO.Repository.SystemePropulsionRepository;
import Projet_POO.Service.SystemePropulsionService;

@Service
public class SystemePropulsionServiceImpl implements SystemePropulsionService {

    private final SystemePropulsionRepository repository;

    public SystemePropulsionServiceImpl(SystemePropulsionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SystemePropulsion> findAll() {
        return repository.findAll();
    }

    @Override
    public SystemePropulsion findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Système non trouvé"));
    }

    @Override
    public SystemePropulsion create(SystemePropulsion systeme) {
        return repository.save(systeme);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
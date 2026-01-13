package Projet_POO.Service.implementation;

import Projet_POO.Domain.Entity.ServiceDeverrouillageMobile;
import Projet_POO.Repository.ServiceDeverrouillageMobileRepository;
import Projet_POO.Service.ServiceDeverrouillageMobileService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceDeverrouillageMobileServiceImpl implements ServiceDeverrouillageMobileService {

    private final ServiceDeverrouillageMobileRepository repository;

    public ServiceDeverrouillageMobileServiceImpl(ServiceDeverrouillageMobileRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ServiceDeverrouillageMobile> findAll() {
        return repository.findAll();
    }

    @Override
    public ServiceDeverrouillageMobile findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service déverrouillage mobile non trouvé"));
    }

    @Override
    public ServiceDeverrouillageMobile create(ServiceDeverrouillageMobile serviceDeverrouillageMobile) {
        return repository.save(serviceDeverrouillageMobile);
    }

    @Override
    public ServiceDeverrouillageMobile update(Long id, ServiceDeverrouillageMobile serviceDeverrouillageMobile) {
        ServiceDeverrouillageMobile existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service déverrouillage mobile non trouvé"));

        // Champs hérités
        existing.setNom(serviceDeverrouillageMobile.getNom());
        existing.setPrix(serviceDeverrouillageMobile.getPrix());

        // Champ spécifique
        existing.setFournisseur(serviceDeverrouillageMobile.getFournisseur());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service déverrouillage mobile non trouvé");
        }
        repository.deleteById(id);
    }
}

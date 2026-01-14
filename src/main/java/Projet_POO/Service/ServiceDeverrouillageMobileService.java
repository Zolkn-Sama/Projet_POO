package Projet_POO.Service;

import Projet_POO.Domain.Entity.ServiceDeverrouillageMobile;
<<<<<<< HEAD

import java.util.List;

public interface ServiceDeverrouillageMobileService {

    List<ServiceDeverrouillageMobile> findAll();

    ServiceDeverrouillageMobile findById(Long id);

    ServiceDeverrouillageMobile create(ServiceDeverrouillageMobile serviceDeverrouillageMobile);

    ServiceDeverrouillageMobile update(Long id, ServiceDeverrouillageMobile serviceDeverrouillageMobile);

    void delete(Long id);
}
=======
import Projet_POO.Repository.ServiceDeverrouillageMobileRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceDeverrouillageMobileService {

    private final ServiceDeverrouillageMobileRepository repository;

    public ServiceDeverrouillageMobileService(ServiceDeverrouillageMobileRepository repository) {
        this.repository = repository;
    }

    public ServiceDeverrouillageMobile sauvegarder(ServiceDeverrouillageMobile service) {
        return repository.save(service);
    }

    public List<ServiceDeverrouillageMobile> listerTous() {
        return repository.findAll();
    }
}
>>>>>>> ALEX

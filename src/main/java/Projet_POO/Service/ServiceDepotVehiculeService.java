package Projet_POO.Service;

<<<<<<< HEAD
import java.util.List;

import Projet_POO.Domain.Entity.ServiceDepotVehicule;

public interface ServiceDepotVehiculeService {

    List<ServiceDepotVehicule> findAll();

    ServiceDepotVehicule findById(Long id);

    ServiceDepotVehicule create(ServiceDepotVehicule serviceDepotVehicule);

    ServiceDepotVehicule update(Long id, ServiceDepotVehicule serviceDepotVehicule);

    void delete(Long id);
}
=======
import Projet_POO.Domain.Entity.ServiceDepotVehicule;
import Projet_POO.Repository.ServiceDepotVehiculeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceDepotVehiculeService {

    private final ServiceDepotVehiculeRepository repository;

    public ServiceDepotVehiculeService(ServiceDepotVehiculeRepository repository) {
        this.repository = repository;
    }

    public ServiceDepotVehicule sauvegarder(ServiceDepotVehicule service) {
        return repository.save(service);
    }

    public List<ServiceDepotVehicule> listerTous() {
        return repository.findAll();
    }
}
>>>>>>> ALEX

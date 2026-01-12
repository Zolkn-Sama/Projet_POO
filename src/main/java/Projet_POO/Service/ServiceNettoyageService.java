package Projet_POO.Service;

import Projet_POO.Domain.Entity.ServiceNettoyage;
import Projet_POO.Repository.ServiceNettoyageRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceNettoyageService {

    private final ServiceNettoyageRepository repository;

    public ServiceNettoyageService(ServiceNettoyageRepository repository) {
        this.repository = repository;
    }

    public ServiceNettoyage sauvegarder(ServiceNettoyage service) {
        return repository.save(service);
    }

    public List<ServiceNettoyage> listerTous() {
        return repository.findAll();
    }
}
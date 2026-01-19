package Projet_POO.Service.implementation;

import Projet_POO.Domain.Entity.ServiceNettoyage;
import Projet_POO.Repository.ServiceNettoyageRepository;
import Projet_POO.Service.ServiceNettoyageService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceNettoyageServiceImpl implements ServiceNettoyageService {

    private final ServiceNettoyageRepository repository;

    public ServiceNettoyageServiceImpl(ServiceNettoyageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ServiceNettoyage> findAll() {
        return repository.findAll();
    }

    @Override
    public ServiceNettoyage findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service nettoyage non trouvé"));
    }

    @Override
    public ServiceNettoyage create(ServiceNettoyage serviceNettoyage) {
        return repository.save(serviceNettoyage);
    }

    @Override
    public ServiceNettoyage update(Long id, ServiceNettoyage serviceNettoyage) {
        ServiceNettoyage existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service nettoyage non trouvé"));

        existing.setNom(serviceNettoyage.getNom());
        existing.setPrix(serviceNettoyage.getPrix());

        existing.setTypeService(serviceNettoyage.getTypeService());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service nettoyage non trouvé");
        }
        repository.deleteById(id);
    }
}

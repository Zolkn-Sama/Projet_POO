package Projet_POO.Service.implementation;

import Projet_POO.Domain.Entity.ServiceDepotVehicule;
import Projet_POO.Repository.ServiceDepotVehiculeRepository;
import Projet_POO.Service.ServiceDepotVehiculeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceDepotVehiculeServiceImpl implements ServiceDepotVehiculeService {

    private final ServiceDepotVehiculeRepository repository;

    public ServiceDepotVehiculeServiceImpl(ServiceDepotVehiculeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ServiceDepotVehicule> findAll() {
        return repository.findAll();
    }

    @Override
    public ServiceDepotVehicule findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service dépôt véhicule non trouvé"));
    }

    @Override
    public ServiceDepotVehicule create(ServiceDepotVehicule serviceDepotVehicule) {
        return repository.save(serviceDepotVehicule);
    }

    @Override
    public ServiceDepotVehicule update(Long id, ServiceDepotVehicule serviceDepotVehicule) {
        ServiceDepotVehicule existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service dépôt véhicule non trouvé"));

        existing.setNom(serviceDepotVehicule.getNom());
        existing.setPrix(serviceDepotVehicule.getPrix());
        existing.setLocalisation(serviceDepotVehicule.getLocalisation());
        existing.setHoraires(serviceDepotVehicule.getHoraires());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service dépôt véhicule non trouvé");
        }
        repository.deleteById(id);
    }
}

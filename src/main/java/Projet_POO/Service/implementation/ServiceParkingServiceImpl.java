package Projet_POO.Service.implementation;

import Projet_POO.Domain.Entity.ServiceParking;
import Projet_POO.Repository.ServiceParkingRepository;
import Projet_POO.Service.ServiceParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceParkingServiceImpl implements ServiceParkingService {

    private final ServiceParkingRepository repository;

    public ServiceParkingServiceImpl(ServiceParkingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ServiceParking> findAll() {
        return repository.findAll();
    }

    @Override
    public ServiceParking findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Service parking non trouvé"
                ));
    }

    @Override
    public ServiceParking create(ServiceParking serviceParking) {
        // Pas besoin de setId(null), JPA s'en sort si l'objet est nouveau
        return repository.save(serviceParking);
    }

    @Override
    public ServiceParking update(Long id, ServiceParking serviceParking) {
        ServiceParking existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Service parking non trouvé"
                ));

        // Champs hérités de ServiceOptionnel
        existing.setNom(serviceParking.getNom());
        existing.setPrix(serviceParking.getPrix());

        // Champs spécifiques à ServiceParking
        existing.setLocalisation(serviceParking.getLocalisation());
        existing.setPourcentageReductionAgent(serviceParking.getPourcentageReductionAgent());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Service parking non trouvé"
            );
        }
        repository.deleteById(id);
    }
}

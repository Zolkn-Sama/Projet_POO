package Projet_POO.Service.implementation;

import Projet_POO.Domain.Entity.ServiceSignature;
import Projet_POO.Repository.ServiceSignatureRepository;
import Projet_POO.Service.ServiceSignatureService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceSignatureServiceImpl implements ServiceSignatureService {

    private final ServiceSignatureRepository repository;

    public ServiceSignatureServiceImpl(ServiceSignatureRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ServiceSignature> findAll() {
        return repository.findAll();
    }

    @Override
    public ServiceSignature findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Service signature non trouvé"
                ));
    }

    @Override
    public ServiceSignature create(ServiceSignature serviceSignature) {
        return repository.save(serviceSignature);
    }

    @Override
    public ServiceSignature update(Long id, ServiceSignature serviceSignature) {
        ServiceSignature existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Service signature non trouvé"
                ));

        // Champs herité de ServiceOptionnel
        existing.setNom(serviceSignature.getNom());
        existing.setPrix(serviceSignature.getPrix());

        // Champ specifique
        existing.setSignature(serviceSignature.getSignature());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Service signature non trouvé"
            );
        }
        repository.deleteById(id);
    }
}

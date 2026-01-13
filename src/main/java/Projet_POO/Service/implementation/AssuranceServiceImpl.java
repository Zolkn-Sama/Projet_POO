package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Assurance;
import Projet_POO.Repository.AssuranceRepository;
import Projet_POO.Service.AssuranceService;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    private final AssuranceRepository assuranceRepository;

    public AssuranceServiceImpl(AssuranceRepository assuranceRepository) {
        this.assuranceRepository = assuranceRepository;
    }

    @Override
    public List<Assurance> findAll() {
        return assuranceRepository.findAll();
    }

    @Override
    public Assurance findById(Long id) {
        return assuranceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Assurance non trouvée"));
    }

    @Override
    public Assurance findByNom(String nom) {
        return assuranceRepository.findByNom(nom)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Assurance non trouvée"));
    }

    @Override
    public Assurance create(Assurance assurance) {
        // Comme il n'y a pas de setId(), on empêche les créations avec un id fourni
        if (assurance.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'id doit être null pour créer une assurance");
        }
        return assuranceRepository.save(assurance);
    }

    @Override
    public Assurance update(Long id, Assurance assurance) {
        Assurance existing = assuranceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Assurance non trouvée"));

        // Champs simples
        existing.setNom(assurance.getNom());
        existing.setEstParDefaut(assurance.isEstParDefaut());

        // ⚠️ IMPORTANT: on ne remplace PAS couvertures/conditions ici
        // car tu as des relations OneToMany avec orphanRemoval.
        // Ces listes se gèrent généralement via leurs propres endpoints/services
        // (CouvertureAssuranceService, ConditionAssuranceService).

        return assuranceRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!assuranceRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Assurance non trouvée");
        }
        assuranceRepository.deleteById(id);
    }
}

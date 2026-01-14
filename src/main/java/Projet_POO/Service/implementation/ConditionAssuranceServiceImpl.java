package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Assurance;
import Projet_POO.Domain.Entity.ConditionAssurance;
import Projet_POO.Repository.AssuranceRepository;
import Projet_POO.Repository.ConditionAssuranceRepository;
import Projet_POO.Service.ConditionAssuranceService;

@Service
public class ConditionAssuranceServiceImpl implements ConditionAssuranceService {

    private final ConditionAssuranceRepository conditionRepo;
    private final AssuranceRepository assuranceRepo;

    public ConditionAssuranceServiceImpl(ConditionAssuranceRepository conditionRepo,
                                         AssuranceRepository assuranceRepo) {
        this.conditionRepo = conditionRepo;
        this.assuranceRepo = assuranceRepo;
    }

    @Override
    public List<ConditionAssurance> findAll() {
        return conditionRepo.findAll();
    }

    @Override
    public ConditionAssurance findById(Long id) {
        return conditionRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ConditionAssurance non trouvée"));
    }

    @Override
    public List<ConditionAssurance> findByAssurance(Long assuranceId) {
        return conditionRepo.findByAssuranceId(assuranceId);
    }

    @Override
    public ConditionAssurance createForAssurance(Long assuranceId, ConditionAssurance condition) {
        Assurance assurance = assuranceRepo.findById(assuranceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Assurance non trouvée"));

        // sécurité : création (si un id est envoyé, on refuse)
        if (condition.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'id doit être null pour créer une condition");
        }

        condition.setAssurance(assurance);
        return conditionRepo.save(condition);
    }

    @Override
    public ConditionAssurance update(Long id, ConditionAssurance condition) {
        ConditionAssurance existing = conditionRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ConditionAssurance non trouvée"));

        // Mise à jour des champs simples
        existing.setAgeMin(condition.getAgeMin());
        existing.setAnciennetePermisMinAnnees(condition.getAnciennetePermisMinAnnees());
        existing.setRestrictionsGeo(condition.getRestrictionsGeo());

        // On ne change PAS l'assurance ici (sinon API ambiguë)
        // Si tu veux permettre le changement d’assurance, on fera un endpoint dédié.

        return conditionRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!conditionRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ConditionAssurance non trouvée");
        }
        conditionRepo.deleteById(id);
    }
}
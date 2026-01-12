package Projet_POO.Service;

import Projet_POO.Domain.Entity.Assurance;
import Projet_POO.Domain.Entity.ConditionAssurance;
import Projet_POO.Repository.AssuranceRepository;
import Projet_POO.Repository.ConditionAssuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionAssuranceService {

    private final ConditionAssuranceRepository repo;
    private final AssuranceRepository assuranceRepo;

    public ConditionAssuranceService(ConditionAssuranceRepository repo, AssuranceRepository assuranceRepo) {
        this.repo = repo;
        this.assuranceRepo = assuranceRepo;
    }

    public ConditionAssurance creerPourAssurance(Long assuranceId, ConditionAssurance c) {
        Assurance a = assuranceRepo.findById(assuranceId)
                .orElseThrow(() -> new RuntimeException("Assurance introuvable: " + assuranceId));
        c.setAssurance(a);
        return repo.save(c);
    }

    public List<ConditionAssurance> parAssurance(Long assuranceId) {
        return repo.findByAssuranceId(assuranceId);
    }
}

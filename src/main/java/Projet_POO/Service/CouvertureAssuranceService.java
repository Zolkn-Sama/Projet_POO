package Projet_POO.Service;

import Projet_POO.Domain.Entity.Assurance;
import Projet_POO.Domain.Entity.CouvertureAssurance;
import Projet_POO.Repository.AssuranceRepository;
import Projet_POO.Repository.CouvertureAssuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouvertureAssuranceService {

    private final CouvertureAssuranceRepository repo;
    private final AssuranceRepository assuranceRepo;

    public CouvertureAssuranceService(CouvertureAssuranceRepository repo, AssuranceRepository assuranceRepo) {
        this.repo = repo;
        this.assuranceRepo = assuranceRepo;
    }

    public CouvertureAssurance creerPourAssurance(Long assuranceId, CouvertureAssurance c) {
        Assurance a = assuranceRepo.findById(assuranceId)
                .orElseThrow(() -> new RuntimeException("Assurance introuvable: " + assuranceId));
        c.setAssurance(a);
        return repo.save(c);
    }

    public List<CouvertureAssurance> parAssurance(Long assuranceId) {
        return repo.findByAssuranceId(assuranceId);
    }
}

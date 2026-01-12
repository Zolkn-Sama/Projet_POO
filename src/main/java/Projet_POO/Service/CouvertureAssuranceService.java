package Projet_POO.Service;

import Projet_POO.Domain.Entity.CouvertureAssurance;
import Projet_POO.Repository.CouvertureAssuranceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CouvertureAssuranceService {

    private final CouvertureAssuranceRepository repository;

    public CouvertureAssuranceService(CouvertureAssuranceRepository repository) {
        this.repository = repository;
    }

    public CouvertureAssurance enregistrer(CouvertureAssurance couverture) {
        return repository.save(couverture);
    }

    public List<CouvertureAssurance> listerToutes() {
        return repository.findAll();
    }
}

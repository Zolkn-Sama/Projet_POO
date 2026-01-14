package Projet_POO.Service;

<<<<<<< HEAD
import java.util.List;

import Projet_POO.Domain.Entity.CouvertureAssurance;

public interface CouvertureAssuranceService {

    List<CouvertureAssurance> findAll();

    CouvertureAssurance findById(Long id);

    List<CouvertureAssurance> findByAssurance(Long assuranceId);

    CouvertureAssurance createForAssurance(Long assuranceId, CouvertureAssurance couverture);

    CouvertureAssurance update(Long id, CouvertureAssurance couverture);

    void delete(Long id);
=======
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
>>>>>>> ALEX
}

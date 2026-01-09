package Projet_POO.Service;

import Projet_POO.Domain.Entity.CouvertureAssurance;
import Projet_POO.Repository.CouvertureAssuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouvertureAssuranceService {

    private final CouvertureAssuranceRepository couvertureRepository;

    public CouvertureAssuranceService(CouvertureAssuranceRepository couvertureRepository) {
        this.couvertureRepository = couvertureRepository;
    }

    public CouvertureAssurance creer(CouvertureAssurance couvertureAssurance) {
        return couvertureRepository.save(couvertureAssurance);
    }

    public List<CouvertureAssurance> toutes() {
        return couvertureRepository.findAll();
    }

    public CouvertureAssurance trouverParId(Long id) {
        return couvertureRepository.findById(id).orElseThrow(() -> new RuntimeException("Couverture d'assurance introuvable"));
    }
}

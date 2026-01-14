package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Assurance;
import Projet_POO.Domain.Entity.CouvertureAssurance;
import Projet_POO.Repository.AssuranceRepository;
import Projet_POO.Repository.CouvertureAssuranceRepository;
import Projet_POO.Service.CouvertureAssuranceService;

@Service
public class CouvertureAssuranceServiceImpl implements CouvertureAssuranceService {

    private final CouvertureAssuranceRepository couvertureRepo;
    private final AssuranceRepository assuranceRepo;

    public CouvertureAssuranceServiceImpl(CouvertureAssuranceRepository couvertureRepo,
                                          AssuranceRepository assuranceRepo) {
        this.couvertureRepo = couvertureRepo;
        this.assuranceRepo = assuranceRepo;
    }

    @Override
    public List<CouvertureAssurance> findAll() {
        return couvertureRepo.findAll();
    }

    @Override
    public CouvertureAssurance findById(Long id) {
        return couvertureRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Couverture non trouvée"));
    }

    @Override
    public List<CouvertureAssurance> findByAssurance(Long assuranceId) {
        return couvertureRepo.findByAssuranceId(assuranceId);
    }

    @Override
    public CouvertureAssurance createForAssurance(Long assuranceId, CouvertureAssurance couverture) {
        Assurance assurance = assuranceRepo.findById(assuranceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Assurance non trouvée"));

        // sécurité création : pas d'id envoyé
        if (couverture.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'id doit être null pour créer une couverture");
        }

        couverture.setAssurance(assurance);
        return couvertureRepo.save(couverture);
    }

    @Override
    public CouvertureAssurance update(Long id, CouvertureAssurance couverture) {
        CouvertureAssurance existing = couvertureRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Couverture non trouvée"));

        existing.setLibelle(couverture.getLibelle());
        existing.setPlafond(couverture.getPlafond());
        existing.setFranchise(couverture.getFranchise());

        // On ne change pas l'assurance ici (endpoint dédié si besoin)
        return couvertureRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!couvertureRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couverture non trouvée");
        }
        couvertureRepo.deleteById(id);
    }
}
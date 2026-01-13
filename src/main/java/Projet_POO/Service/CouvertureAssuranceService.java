package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.CouvertureAssurance;

public interface CouvertureAssuranceService {

    List<CouvertureAssurance> findAll();

    CouvertureAssurance findById(Long id);

    List<CouvertureAssurance> findByAssurance(Long assuranceId);

    CouvertureAssurance createForAssurance(Long assuranceId, CouvertureAssurance couverture);

    CouvertureAssurance update(Long id, CouvertureAssurance couverture);

    void delete(Long id);
}
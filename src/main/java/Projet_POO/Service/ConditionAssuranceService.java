package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.ConditionAssurance;

public interface ConditionAssuranceService {

    List<ConditionAssurance> findAll();

    ConditionAssurance findById(Long id);

    List<ConditionAssurance> findByAssurance(Long assuranceId);

    ConditionAssurance createForAssurance(Long assuranceId, ConditionAssurance condition);

    ConditionAssurance update(Long id, ConditionAssurance condition);

    void delete(Long id);
}

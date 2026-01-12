package Projet_POO.Repository;

import Projet_POO.Domain.Entity.ConditionAssurance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConditionAssuranceRepository extends JpaRepository<ConditionAssurance, Long> {
    List<ConditionAssurance> findByAssuranceId(Long assuranceId);
}

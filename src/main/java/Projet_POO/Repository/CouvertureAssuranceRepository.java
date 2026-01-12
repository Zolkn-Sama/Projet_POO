package Projet_POO.Repository;

import Projet_POO.Domain.Entity.CouvertureAssurance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CouvertureAssuranceRepository extends JpaRepository<CouvertureAssurance, Long> {
    List<CouvertureAssurance> findByAssuranceId(Long assuranceId);
}

package Projet_POO.Repository;

import Projet_POO.Domain.Entity.CouvertureAssurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouvertureAssuranceRepository extends JpaRepository<CouvertureAssurance, Integer> {
    // Permet les opérations CRUD standards
}

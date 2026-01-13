package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.CouvertureAssurance;

@Repository
public interface CouvertureAssuranceRepository extends JpaRepository<CouvertureAssurance, Long> {

    List<CouvertureAssurance> findAll();

    Optional<CouvertureAssurance> findById(Long id);

    List<CouvertureAssurance> findByAssuranceId(Long assuranceId);
}
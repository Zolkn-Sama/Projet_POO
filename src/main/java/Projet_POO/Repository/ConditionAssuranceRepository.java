package Projet_POO.Repository;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.ConditionAssurance;

@Repository
public interface ConditionAssuranceRepository extends JpaRepository<ConditionAssurance, Long> {

    List<ConditionAssurance> findAll();

    Optional<ConditionAssurance> findById(Long id);

    List<ConditionAssurance> findByAssuranceId(Long assuranceId);
=======
import Projet_POO.Domain.Entity.ConditionAssurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionAssuranceRepository extends JpaRepository<ConditionAssurance, Integer> {
>>>>>>> ALEX
}

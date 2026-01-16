package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.ParrainageLoueur;

@Repository
public interface ParrainageLoueurRepository extends JpaRepository<ParrainageLoueur, Long> {
    Optional<ParrainageLoueur> findByCode(String code);
    List<ParrainageLoueur> findAllByFilleul_Id(Long filleulId);
}

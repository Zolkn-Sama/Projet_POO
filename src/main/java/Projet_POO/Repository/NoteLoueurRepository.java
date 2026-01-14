package Projet_POO.Repository;

import Projet_POO.Domain.Entity.NoteLoueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoteLoueurRepository extends JpaRepository<NoteLoueur, Long> {

    // 🟢 Spring Data JPA va chercher dans l'objet 'loueur', puis son champ 'id'
    List<NoteLoueur> findByLoueurId(Long loueurId);
}
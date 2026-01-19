package Projet_POO.Repository;

import Projet_POO.Domain.Entity.NoteLoueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoteLoueurRepository extends JpaRepository<NoteLoueur, Long> {

    List<NoteLoueur> findByLoueurId(Long loueurId);
}

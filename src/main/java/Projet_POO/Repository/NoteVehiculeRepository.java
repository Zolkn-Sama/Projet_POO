package Projet_POO.Repository;

import Projet_POO.Domain.Entity.NoteVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoteVehiculeRepository extends JpaRepository<NoteVehicule, Long> {

    // 🟢 Recherche automatique : Spring Data cherche dans l'objet 'vehicule' puis son champ 'id'
    List<NoteVehicule> findByVehiculeId(Long vehiculeId);
}
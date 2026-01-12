package Projet_POO.Repository;

import Projet_POO.Domain.Entity.NoteVehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteVehiculeRepository extends JpaRepository<NoteVehicule, Long> {
    List<NoteVehicule> findByVehiculeId(Long vehiculeId);
}

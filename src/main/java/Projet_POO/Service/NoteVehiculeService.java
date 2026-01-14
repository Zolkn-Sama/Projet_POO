package Projet_POO.Service;

import Projet_POO.Domain.Entity.NoteVehicule;
import java.util.List;

public interface NoteVehiculeService {

    // Création d'une note liée à un véhicule spécifique
    NoteVehicule creer(NoteVehicule note, Long vehiculeId);

    List<NoteVehicule> toutes();
    List<NoteVehicule> parVehicule(Long vehiculeId);
}
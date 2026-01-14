package Projet_POO.Service;

import Projet_POO.Domain.Entity.NoteVehicule;
import java.util.List;

/**
 * Interface pour le service de gestion des évaluations de véhicules.
 * Définit les fonctionnalités de création et de consultation des notes.
 */
public interface NoteVehiculeService {

    /**
     * Enregistre une nouvelle note liée à un véhicule spécifique.
     * 
     * @param note L'entité NoteVehicule à sauvegarder.
     * @return L'évaluation enregistrée.
     */
    NoteVehicule create(NoteVehicule note);

    /**
     * Récupère toutes les notes de véhicules enregistrées en base.
     * 
     * @return Une liste complète de NoteVehicule.
     */
    List<NoteVehicule> getAll();

    /**
     * Recherche les notes correspondant à un véhicule donné.
     * 
     * @param vehiculeId L'identifiant technique du véhicule.
     * @return Une liste de notes filtrées par véhicule.
     */
    List<NoteVehicule> getByVehiculeId(Long vehiculeId);
}
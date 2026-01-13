package Projet_POO.Controller;

import Projet_POO.Domain.Entity.NoteVehicule;
import Projet_POO.Service.NoteVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes-vehicule")
public class NoteVehiculeController {

    @Autowired
    private NoteVehiculeService noteVehiculeService;

    /**
     * Enregistre une évaluation pour un véhicule.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteVehicule create(@RequestBody NoteVehicule note) {
        return noteVehiculeService.create(note);
    }

    /**
     * Liste toutes les évaluations de véhicules.
     */
    @GetMapping
    public List<NoteVehicule> getAll() {
        return noteVehiculeService.getAll();
    }

    /**
     * Récupère la liste des notes d'un véhicule par son identifiant.
     * La gestion d'erreur (404) est déléguée à la couche Service.
     */
    @GetMapping("/vehicule/{vehiculeId}")
    public List<NoteVehicule> getByVehiculeId(@PathVariable Long vehiculeId) {
        return noteVehiculeService.getByVehiculeId(vehiculeId);
    }
}
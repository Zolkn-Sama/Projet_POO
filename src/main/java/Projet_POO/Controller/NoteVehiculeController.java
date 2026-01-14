package Projet_POO.Controller;

import Projet_POO.Domain.Entity.NoteVehicule;
import Projet_POO.Service.NoteVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes-vehicule")
public class NoteVehiculeController {

    @Autowired
    private NoteVehiculeService noteVehiculeService;

    /**
     * Enregistre une nouvelle évaluation pour un véhicule spécifique.
     * URL : POST /api/notes-vehicule/{vehiculeId}
     */
    @PostMapping("/{vehiculeId}") // 🟢 L'ID du véhicule est dans l'URL
    @ResponseStatus(HttpStatus.CREATED)
    public NoteVehicule create(@PathVariable Long vehiculeId, @RequestBody NoteVehicule note) {
        return noteVehiculeService.creer(note, vehiculeId);
    }

    /**
     * Liste toutes les évaluations de tous les véhicules.
     */
    @GetMapping
    public List<NoteVehicule> getAll() {
        return noteVehiculeService.toutes();
    }

    /**
     * Récupère les notes d'un véhicule spécifique.
     * URL : GET /api/notes-vehicule/vehicule/{vehiculeId}
     */
    @GetMapping("/vehicule/{vehiculeId}")
    public List<NoteVehicule> getByVehicule(@PathVariable Long vehiculeId) {
        return noteVehiculeService.parVehicule(vehiculeId);
    }
}
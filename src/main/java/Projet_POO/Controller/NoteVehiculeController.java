package Projet_POO.Controller;

import Projet_POO.Domain.Entity.NoteVehicule;
import Projet_POO.Service.NoteVehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes-vehicules")
public class NoteVehiculeController {

    private final NoteVehiculeService service;

    public NoteVehiculeController(NoteVehiculeService service) {
        this.service = service;
    }

    @PostMapping
    public NoteVehicule creer(@RequestBody NoteVehicule note) {
        return service.creer(note);
    }

    @GetMapping
    public List<NoteVehicule> toutes() {
        return service.toutes();
    }

    @GetMapping("/vehicule/{vehiculeId}")
    public List<NoteVehicule> parVehicule(@PathVariable Long vehiculeId) {
        return service.parVehicule(vehiculeId);
    }
}

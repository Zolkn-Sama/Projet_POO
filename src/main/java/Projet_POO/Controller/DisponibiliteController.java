package Projet_POO.Controller;

import Projet_POO.Domain.Entity.Disponibilite;
import Projet_POO.Service.DisponibiliteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disponibilites")
public class DisponibiliteController {

    private final DisponibiliteService service;

    public DisponibiliteController(DisponibiliteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Disponibilite> getAll() {
        return service.listerToutes();
    }

    @PostMapping
    public Disponibilite creer(@RequestBody Disponibilite disponibilite) {
        return service.enregistrer(disponibilite);
    }
}

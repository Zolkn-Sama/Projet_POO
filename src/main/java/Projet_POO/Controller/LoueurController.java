package Projet_POO.Controller;

import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Service.LoueurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loueurs")
public class LoueurController {

    private final LoueurService service;

    public LoueurController(LoueurService service) {
        this.service = service;
    }

    @PostMapping
    public Loueur creer(@RequestBody Loueur loueur) {
        return service.creer(loueur);
    }

    @GetMapping
    public List<Loueur> tous() {
        return service.tous();
    }

    @GetMapping("/{id}")
    public Loueur parId(@PathVariable Long id) {
        return service.parId(id);
    }
}

package Projet_POO.Controller;

import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.ParrainageLoueur;
import Projet_POO.Service.ParrainageLoueurService;

@RestController
@RequestMapping("/parrainages/loueurs")
public class ParrainageLoueurController {

    private final ParrainageLoueurService service;

    public ParrainageLoueurController(ParrainageLoueurService service) {
        this.service = service;
    }

    @PostMapping("/parrain/{parrainId}")
    public ParrainageLoueur creerCode(@PathVariable Long parrainId) {
        return service.creerCode(parrainId);
    }

    @PostMapping("/utiliser/{code}/filleul/{filleulId}")
    public ParrainageLoueur utiliserCode(@PathVariable String code, @PathVariable Long filleulId) {
        return service.utiliserCode(code, filleulId);
    }

    // tester manuellement
    @PostMapping("/verifier/{filleulId}")
    public void verifier(@PathVariable Long filleulId) {
        service.verifierEtCrediter(filleulId);
    }
}

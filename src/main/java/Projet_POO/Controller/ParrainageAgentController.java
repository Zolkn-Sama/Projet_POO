package Projet_POO.Controller;

import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.ParrainageAgent;
import Projet_POO.Service.ParrainageAgentService;

@RestController
@RequestMapping("/parrainages/agents")
public class ParrainageAgentController {

    private final ParrainageAgentService service;

    public ParrainageAgentController(ParrainageAgentService service) {
        this.service = service;
    }

    @PostMapping("/parrain/{parrainId}")
    public ParrainageAgent creerCode(@PathVariable Long parrainId) {
        return service.creerCode(parrainId);
    }

    @PostMapping("/utiliser/{code}/filleul/{filleulId}")
    public ParrainageAgent utiliserCode(@PathVariable String code, @PathVariable Long filleulId) {
        return service.utiliserCode(code, filleulId);
    }

    @PostMapping("/verifier/{filleulId}")
    public void verifier(@PathVariable Long filleulId) {
        service.verifierEtCrediter(filleulId);
    }
}

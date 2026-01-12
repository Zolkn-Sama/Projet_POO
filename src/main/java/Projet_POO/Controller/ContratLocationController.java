package Projet_POO.Controller;

import Projet_POO.Domain.Entity.ContratLocation;
import Projet_POO.Service.ContratLocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrats")
public class ContratLocationController {

    private final ContratLocationService service;

    public ContratLocationController(ContratLocationService service) {
        this.service = service;
    }

    @PostMapping
    public ContratLocation creer(@RequestBody ContratLocation contrat) {
        return service.creerContrat(contrat);
    }

    @GetMapping
    public List<ContratLocation> tous() {
        return service.tous();
    }

    @GetMapping("/loueur/{loueurId}")
    public List<ContratLocation> parLoueur(@PathVariable Long loueurId) {
        return service.contratsLoueur(loueurId);
    }
}

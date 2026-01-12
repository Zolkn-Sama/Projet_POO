package Projet_POO.Controller;

import Projet_POO.Domain.Entity.ConditionAssurance;
import Projet_POO.Service.ConditionAssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// On change le chemin ici pour éviter le conflit avec AssuranceController
@RequestMapping("/conditions-assurances")
public class ConditionAssuranceController {

    private final ConditionAssuranceService service;

    public ConditionAssuranceController(ConditionAssuranceService service) {
        this.service = service;
    }

    // Cette méthode répondra maintenant à GET http://localhost:8090/conditions-assurances
    @GetMapping
    public List<ConditionAssurance> getAll() {
        return service.listerToutes();
    }

    // Cette méthode répondra à POST http://localhost:8090/conditions-assurances
    @PostMapping
    public ConditionAssurance creer(@RequestBody ConditionAssurance condition) {
        return service.sauvegarder(condition);
    }
}
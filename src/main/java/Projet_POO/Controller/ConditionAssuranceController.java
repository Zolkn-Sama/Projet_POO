package Projet_POO.Controller;

import Projet_POO.Domain.Entity.ConditionAssurance;
import Projet_POO.Service.ConditionAssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conditions-assurance")
public class ConditionAssuranceController {

    private final ConditionAssuranceService service;

    public ConditionAssuranceController(ConditionAssuranceService service) {
        this.service = service;
    }

    @PostMapping
    public ConditionAssurance creer(@RequestBody ConditionAssurance conditionAssurance) {
        return service.creer(conditionAssurance);
    }

    @GetMapping
    public List<ConditionAssurance> toutes() {
        return service.toutes();
    }

    @GetMapping("/{id}")
    public ConditionAssurance trouverParId(@PathVariable Long id) {
        return service.trouverParId(id);
    }
}

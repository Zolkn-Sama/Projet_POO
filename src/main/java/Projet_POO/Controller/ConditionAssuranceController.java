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

    @PostMapping("/assurance/{assuranceId}")
    public ConditionAssurance creer(@PathVariable Long assuranceId, @RequestBody ConditionAssurance c) {
        return service.creerPourAssurance(assuranceId, c);
    }

    @GetMapping("/assurance/{assuranceId}")
    public List<ConditionAssurance> parAssurance(@PathVariable Long assuranceId) {
        return service.parAssurance(assuranceId);
    }
}

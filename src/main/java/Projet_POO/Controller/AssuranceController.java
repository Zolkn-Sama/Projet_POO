package Projet_POO.Controller;

import Projet_POO.Domain.Entity.Assurance;
import Projet_POO.Service.AssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assurances")
public class AssuranceController {

    private final AssuranceService service;

    public AssuranceController(AssuranceService service) {
        this.service = service;
    }

    @PostMapping
    public Assurance creer(@RequestBody Assurance assurance) {
        return service.creer(assurance);
    }

    @GetMapping
    public List<Assurance> toutes() {
        return service.toutes();
    }
}

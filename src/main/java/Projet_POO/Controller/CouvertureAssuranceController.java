package Projet_POO.Controller;

import Projet_POO.Domain.Entity.CouvertureAssurance;
import Projet_POO.Service.CouvertureAssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couvertures")
public class CouvertureAssuranceController {

    private final CouvertureAssuranceService service;

    public CouvertureAssuranceController(CouvertureAssuranceService service) {
        this.service = service;
    }

    @PostMapping("/assurance/{assuranceId}")
    public CouvertureAssurance creer(@PathVariable Long assuranceId, @RequestBody CouvertureAssurance c) {
        return service.creerPourAssurance(assuranceId, c);
    }

    @GetMapping("/assurance/{assuranceId}")
    public List<CouvertureAssurance> parAssurance(@PathVariable Long assuranceId) {
        return service.parAssurance(assuranceId);
    }
}

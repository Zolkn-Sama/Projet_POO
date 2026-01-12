package Projet_POO.Controller;

import Projet_POO.Domain.Entity.CouvertureAssurance;
import Projet_POO.Service.CouvertureAssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couvertures-assurances")
public class CouvertureAssuranceController {

    private final CouvertureAssuranceService service;

    public CouvertureAssuranceController(CouvertureAssuranceService service) {
        this.service = service;
    }

    @GetMapping
    public List<CouvertureAssurance> getAll() {
        return service.listerToutes();
    }

    @PostMapping
    public CouvertureAssurance creer(@RequestBody CouvertureAssurance couverture) {
        return service.enregistrer(couverture);
    }
}

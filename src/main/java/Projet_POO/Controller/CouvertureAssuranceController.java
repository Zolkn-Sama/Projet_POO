package Projet_POO.Controller;

import Projet_POO.Domain.Entity.CouvertureAssurance;
import Projet_POO.Service.CouvertureAssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couvertures-assurance")
public class CouvertureAssuranceController {

    private final CouvertureAssuranceService service;

    public CouvertureAssuranceController(CouvertureAssuranceService service) {
        this.service = service;
    }

    @PostMapping
    public CouvertureAssurance creer(@RequestBody CouvertureAssurance couvertureAssurance) {
        return service.creer(couvertureAssurance);
    }

    @GetMapping
    public List<CouvertureAssurance> toutes() {
        return service.toutes();
    }

    @GetMapping("/{id}")
    public CouvertureAssurance trouverParId(@PathVariable Long id) {
        return service.trouverParId(id);
    }
}

package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.CouvertureAssurance;
import Projet_POO.Service.CouvertureAssuranceService;

@RestController
@RequestMapping("/couvertures")
public class CouvertureAssuranceController {

    private final CouvertureAssuranceService couvertureService;

    public CouvertureAssuranceController(CouvertureAssuranceService couvertureService) {
        this.couvertureService = couvertureService;
    }

    // optionnel : toutes les couvertures
    @GetMapping
    public List<CouvertureAssurance> getAll() {
        return couvertureService.findAll();
    }

    // optionnel : une couverture par id
    @GetMapping("/{id}")
    public CouvertureAssurance getById(@PathVariable Long id) {
        return couvertureService.findById(id);
    }

    @PostMapping("/assurance/{assuranceId}")
    public CouvertureAssurance createForAssurance(@PathVariable Long assuranceId,
                                                  @RequestBody CouvertureAssurance couverture) {
        return couvertureService.createForAssurance(assuranceId, couverture);
    }

    @GetMapping("/assurance/{assuranceId}")
    public List<CouvertureAssurance> getByAssurance(@PathVariable Long assuranceId) {
        return couvertureService.findByAssurance(assuranceId);
    }

    // optionnel : update/delete
    @PutMapping("/{id}")
    public CouvertureAssurance update(@PathVariable Long id, @RequestBody CouvertureAssurance couverture) {
        return couvertureService.update(id, couverture);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        couvertureService.delete(id);
    }
}
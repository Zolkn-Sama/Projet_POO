package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.Assurance;
import Projet_POO.Service.AssuranceService;

@RestController
@RequestMapping("/assurances")
public class AssuranceController {

    private final AssuranceService assuranceService;

    public AssuranceController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    @GetMapping
    public List<Assurance> getAll() {
        return assuranceService.findAll();
    }

    @GetMapping("/{id}")
    public Assurance getById(@PathVariable Long id) {
        return assuranceService.findById(id);
    }

    // rechercher par nom 
    @GetMapping("/by-nom/{nom}")
    public Assurance getByNom(@PathVariable String nom) {
        return assuranceService.findByNom(nom);
    }

    @PostMapping
    public Assurance create(@RequestBody Assurance assurance) {
        return assuranceService.create(assurance);
    }

    @PutMapping("/{id}")
    public Assurance update(@PathVariable Long id, @RequestBody Assurance assurance) {
        return assuranceService.update(id, assurance);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        assuranceService.delete(id);
    }
}

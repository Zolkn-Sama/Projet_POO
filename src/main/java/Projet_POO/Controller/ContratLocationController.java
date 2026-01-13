package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.ContratLocation;
import Projet_POO.Service.ContratLocationService;

@RestController
@RequestMapping("/contrats")
public class ContratLocationController {

    private final ContratLocationService contratService;

    public ContratLocationController(ContratLocationService contratService) {
        this.contratService = contratService;
    }

    @GetMapping
    public List<ContratLocation> getAll() {
        return contratService.findAll();
    }

    @GetMapping("/{id}")
    public ContratLocation getById(@PathVariable Long id) {
        return contratService.findById(id);
    }

    @GetMapping("/loueur/{loueurId}")
    public List<ContratLocation> getByLoueur(@PathVariable Long loueurId) {
        return contratService.findByLoueur(loueurId);
    }

    @GetMapping("/vehicule/{vehiculeId}")
    public List<ContratLocation> getByVehicule(@PathVariable Long vehiculeId) {
        return contratService.findByVehicule(vehiculeId);
    }

    @PostMapping
    public ContratLocation create(@RequestBody ContratLocation contrat) {
        return contratService.create(contrat);
    }

    @PutMapping("/{id}")
    public ContratLocation update(@PathVariable Long id, @RequestBody ContratLocation contrat) {
        return contratService.update(id, contrat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contratService.delete(id);
    }
}

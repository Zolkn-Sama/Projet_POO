package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.TypeVehicule;
import Projet_POO.Service.TypeVehiculeService;

@RestController
@RequestMapping("/types-vehicules")
public class TypeVehiculeController {

    private final TypeVehiculeService typeVehiculeService;

    public TypeVehiculeController(TypeVehiculeService typeVehiculeService) {
        this.typeVehiculeService = typeVehiculeService;
    }

    @GetMapping
    public List<TypeVehicule> getAll() {
        return typeVehiculeService.findAll();
    }

    @GetMapping("/{id}")
    public TypeVehicule getById(@PathVariable Long id) {
        return typeVehiculeService.findById(id);
    }

    @GetMapping("/libelle/{libelle}")
    public TypeVehicule getByLibelle(@PathVariable String libelle) {
        return typeVehiculeService.findByLibelle(libelle);
    }

    @GetMapping("/domaine/{domaine}")
    public List<TypeVehicule> getByDomaine(@PathVariable String domaine) {
        return typeVehiculeService.findByDomaine(domaine);
    }

    @PostMapping
    public TypeVehicule create(@RequestBody TypeVehicule typeVehicule) {
        return typeVehiculeService.create(typeVehicule);
    }

    @PutMapping("/{id}")
    public TypeVehicule update(@PathVariable Long id, @RequestBody TypeVehicule typeVehicule) {
        return typeVehiculeService.update(id, typeVehicule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        typeVehiculeService.delete(id);
    }
}

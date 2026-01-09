package Projet_POO.Controller;

import Projet_POO.Domain.Entity.CaracteristiquesVehicule;
import Projet_POO.Service.CaracteristiquesVehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caracteristiques-vehicules")
public class CaracteristiquesVehiculeController {

    private final CaracteristiquesVehiculeService service;

    public CaracteristiquesVehiculeController(CaracteristiquesVehiculeService service) {
        this.service = service;
    }

    @PostMapping
    public CaracteristiquesVehicule creer(@RequestBody CaracteristiquesVehicule caracteristiquesVehicule) {
        return service.creer(caracteristiquesVehicule);
    }

    @GetMapping
    public List<CaracteristiquesVehicule> toutes() {
        return service.toutes();
    }

    @GetMapping("/{id}")
    public CaracteristiquesVehicule trouverParId(@PathVariable Long id) {
        return service.trouverParId(id);
    }
}

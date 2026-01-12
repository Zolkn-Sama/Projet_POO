package Projet_POO.Controller;

import Projet_POO.Domain.Entity.TypeVehicule;
import Projet_POO.Service.TypeVehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types-vehicules")
public class TypeVehiculeController {

    private final TypeVehiculeService service;

    public TypeVehiculeController(TypeVehiculeService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypeVehicule> getAll() {
        return service.listerTous();
    }

    @PostMapping
    public TypeVehicule creer(@RequestBody TypeVehicule type) {
        return service.sauvegarder(type);
    }
}
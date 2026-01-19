package Projet_POO.Controller;

import Projet_POO.Domain.Entity.CaracteristiquesVehicule;
import Projet_POO.Service.CaracteristiquesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caracteristiques")
public class CaracteristiquesController {

    private final CaracteristiquesService caracteristiquesService;

    public CaracteristiquesController(CaracteristiquesService caracteristiquesService) {
        this.caracteristiquesService = caracteristiquesService;
    }

    // recuperer toutes les caractéristiques existantes
    @GetMapping
    public List<CaracteristiquesVehicule> listerToutes() {
        return caracteristiquesService.findAll();
    }

    // Rechercher par marque
    @GetMapping("/recherche")
    public List<CaracteristiquesVehicule> parMarque(@RequestParam String marque) {
        return caracteristiquesService.findByMarque(marque);
    }

    @PostMapping
    public CaracteristiquesVehicule ajouter(@RequestBody CaracteristiquesVehicule carac) {
        return caracteristiquesService.sauvegarder(carac);
    }
}

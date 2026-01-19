package Projet_POO.Controller;

import Projet_POO.Domain.Entity.ControleVehicule;
import Projet_POO.Service.ControleVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class ControleVehiculeController {

    @Autowired
    private ControleVehiculeService service;
    @PostMapping("/{vehiculeId}/controle")
    @ResponseStatus(HttpStatus.CREATED)
    public ControleVehicule create(@PathVariable Long vehiculeId, @RequestBody ControleVehicule controle) {
        // On passe l'ID du véhicule au service pour faire la liaison
        return service.creer(controle, vehiculeId);
    }

    @GetMapping("/{vehiculeId}/alertes")
    public List<String> getAlertes(@PathVariable Long vehiculeId) {
        // On demande les alertes directement pour le véhicule
        return service.genererAlertesPourVehicule(vehiculeId);
    }
}

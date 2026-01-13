package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Service.VehiculeService;

@RestController
@RequestMapping("/vehicules")
public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping
    public List<Vehicule> getAll() {
        return vehiculeService.findAll();
    }

    @GetMapping("/ById/{id}")
    public Vehicule getById(@PathVariable int id) {
        return vehiculeService.findById(id);
    }

    @GetMapping("/ByImmatriculation/{immatriculation}")
    public Vehicule getByImmatriculation(@PathVariable String immatriculation) {
        return vehiculeService.findByImmatriculation(immatriculation);
    }

    @PostMapping
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.create(vehicule);
    }

    @PutMapping("/{id}")
    public Vehicule update(@PathVariable Long id,
            @RequestBody Vehicule vehicule) {
        return vehiculeService.update(id, vehicule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vehiculeService.delete(id);
    }
}

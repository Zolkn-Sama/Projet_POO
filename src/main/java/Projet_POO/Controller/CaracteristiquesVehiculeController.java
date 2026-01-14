package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.CaracteristiquesVehicule;
import Projet_POO.Service.CaracteristiquesVehiculeService;

@RestController
@RequestMapping("/caracteristiques-vehicules")
public class CaracteristiquesVehiculeController {

    private final CaracteristiquesVehiculeService caracteristiquesVehiculeService;

    public CaracteristiquesVehiculeController(CaracteristiquesVehiculeService caracteristiquesVehiculeService) {
        this.caracteristiquesVehiculeService = caracteristiquesVehiculeService;
    }

    @GetMapping
    public List<CaracteristiquesVehicule> getAll() {
        return caracteristiquesVehiculeService.findAll();
    }

    @GetMapping("/{id}")
    public CaracteristiquesVehicule getById(@PathVariable Long id) {
        return caracteristiquesVehiculeService.findById(id);
    }

    @GetMapping("/marque/{marque}")
    public List<CaracteristiquesVehicule> getByMarque(@PathVariable String marque) {
        return caracteristiquesVehiculeService.findByMarque(marque);
    }

    @GetMapping("/modele/{modele}")
    public List<CaracteristiquesVehicule> getByModele(@PathVariable String modele) {
        return caracteristiquesVehiculeService.findByModele(modele);
    }

    @GetMapping("/couleur/{couleur}")
    public List<CaracteristiquesVehicule> getByCouleur(@PathVariable String couleur) {
        return caracteristiquesVehiculeService.findByCouleur(couleur);
    }

    @GetMapping("/permis/{categoriePermisRequise}")
    public List<CaracteristiquesVehicule> getByPermis(@PathVariable String categoriePermisRequise) {
        return caracteristiquesVehiculeService.findByCategoriePermisRequise(categoriePermisRequise);
    }

    @GetMapping("/places/{nbPlaces}")
    public List<CaracteristiquesVehicule> getByNbPlaces(@PathVariable int nbPlaces) {
        return caracteristiquesVehiculeService.findByNbPlaces(nbPlaces);
    }

    @PostMapping
    public CaracteristiquesVehicule create(@RequestBody CaracteristiquesVehicule caracteristiquesVehicule) {
        return caracteristiquesVehiculeService.create(caracteristiquesVehicule);
    }

    @PutMapping("/{id}")
    public CaracteristiquesVehicule update(@PathVariable Long id, @RequestBody CaracteristiquesVehicule caracteristiquesVehicule) {
        return caracteristiquesVehiculeService.update(id, caracteristiquesVehicule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        caracteristiquesVehiculeService.delete(id);
    }
}

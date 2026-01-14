package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.OptionVehicule;
import Projet_POO.Domain.Enums.CodeOption;
import Projet_POO.Service.OptionVehiculeService;

@RestController
@RequestMapping("/options-vehicule")
public class OptionVehiculeController {

    private final OptionVehiculeService optionVehiculeService;

    public OptionVehiculeController(OptionVehiculeService optionVehiculeService) {
        this.optionVehiculeService = optionVehiculeService;
    }

    @GetMapping
    public List<OptionVehicule> getAll() {
        return optionVehiculeService.findAll();
    }

    @GetMapping("/{id}")
    public OptionVehicule getById(@PathVariable Long id) {
        return optionVehiculeService.findById(id);
    }

    @GetMapping("/code/{code}")
    public OptionVehicule getByCode(@PathVariable CodeOption code) {
        return optionVehiculeService.findByCode(code);
    }

    @PostMapping
    public OptionVehicule create(@RequestBody OptionVehicule optionVehicule) {
        return optionVehiculeService.create(optionVehicule);
    }

    @PutMapping("/{id}")
    public OptionVehicule update(
            @PathVariable Long id,
            @RequestParam CodeOption code) {
        return optionVehiculeService.update(id, code);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        optionVehiculeService.delete(id);
    }
}

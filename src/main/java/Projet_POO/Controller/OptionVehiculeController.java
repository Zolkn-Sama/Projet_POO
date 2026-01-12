package Projet_POO.Controller;

import Projet_POO.Domain.Entity.OptionVehicule;
import Projet_POO.Service.OptionVehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionVehiculeController {

    private final OptionVehiculeService service;

    public OptionVehiculeController(OptionVehiculeService service) {
        this.service = service;
    }

    @PostMapping
    public OptionVehicule creer(@RequestBody OptionVehicule o) {
        return service.creer(o);
    }

    @GetMapping
    public List<OptionVehicule> tous() {
        return service.tous();
    }
}

package Projet_POO.Controller;

import Projet_POO.Domain.Entity.SystemePropulsion;
import Projet_POO.Service.SystemePropulsionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemes-propulsion")
public class SystemePropulsionController {

    private final SystemePropulsionService service;

    public SystemePropulsionController(SystemePropulsionService service) {
        this.service = service;
    }

    @GetMapping
    public List<SystemePropulsion> getAll() {
        return service.listerTous();
    }

    @PostMapping
    public SystemePropulsion creer(@RequestBody SystemePropulsion systeme) {
        return service.sauvegarder(systeme);
    }
}
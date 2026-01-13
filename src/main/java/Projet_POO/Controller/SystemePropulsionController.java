package Projet_POO.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Projet_POO.Domain.Entity.SystemePropulsion;
import Projet_POO.Service.SystemePropulsionService;

@RestController
@RequestMapping("/api/propulsions")
public class SystemePropulsionController {

    private final SystemePropulsionService service;

    public SystemePropulsionController(SystemePropulsionService service) {
        this.service = service;
    }

    @GetMapping
    public List<SystemePropulsion> getAll() {
        return service.findAll();
    }

    @PostMapping
    public SystemePropulsion create(@RequestBody SystemePropulsion systeme) {
        return service.create(systeme);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

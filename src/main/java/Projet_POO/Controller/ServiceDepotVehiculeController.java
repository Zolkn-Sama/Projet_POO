package Projet_POO.Controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projet_POO.Domain.Entity.ServiceDepotVehicule;
import Projet_POO.Service.ServiceDepotVehiculeService;
=======
import Projet_POO.Domain.Entity.ServiceDepotVehicule;
import Projet_POO.Service.ServiceDepotVehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
>>>>>>> ALEX

@RestController
@RequestMapping("/services-depot")
public class ServiceDepotVehiculeController {

    private final ServiceDepotVehiculeService service;

    public ServiceDepotVehiculeController(ServiceDepotVehiculeService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceDepotVehicule> getAll() {
<<<<<<< HEAD
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ServiceDepotVehicule getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ServiceDepotVehicule create(@RequestBody ServiceDepotVehicule serviceDepotVehicule) {
        return service.create(serviceDepotVehicule);
    }

    @PutMapping("/{id}")
    public ServiceDepotVehicule update(@PathVariable Long id, @RequestBody ServiceDepotVehicule serviceDepotVehicule) {
        return service.update(id, serviceDepotVehicule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
=======
        return service.listerTous();
    }

    @PostMapping
    public ServiceDepotVehicule creer(@RequestBody ServiceDepotVehicule serviceDepot) {
        return service.sauvegarder(serviceDepot);
    }
}
>>>>>>> ALEX

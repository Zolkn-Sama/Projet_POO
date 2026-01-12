package Projet_POO.Controller;

import Projet_POO.Domain.Entity.ServiceDepotVehicule;
import Projet_POO.Service.ServiceDepotVehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services-depot")
public class ServiceDepotVehiculeController {

    private final ServiceDepotVehiculeService service;

    public ServiceDepotVehiculeController(ServiceDepotVehiculeService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceDepotVehicule> getAll() {
        return service.listerTous();
    }

    @PostMapping
    public ServiceDepotVehicule creer(@RequestBody ServiceDepotVehicule serviceDepot) {
        return service.sauvegarder(serviceDepot);
    }
}
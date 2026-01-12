package Projet_POO.Controller;

import Projet_POO.Domain.Entity.ServiceNettoyage;
import Projet_POO.Service.ServiceNettoyageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services-nettoyage")
public class ServiceNettoyageController {

    private final ServiceNettoyageService service;

    public ServiceNettoyageController(ServiceNettoyageService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceNettoyage> getAll() {
        return service.listerTous();
    }

    @PostMapping
    public ServiceNettoyage creer(@RequestBody ServiceNettoyage nettoyage) {
        return service.sauvegarder(nettoyage);
    }
}
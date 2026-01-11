package Projet_POO.Controller;

import Projet_POO.Domain.Entity.ServiceDepotVehicule;
import Projet_POO.Domain.Entity.ServiceDeverrouillageMobile;
import Projet_POO.Domain.Entity.ServiceNettoyage;
import Projet_POO.Domain.Entity.ServiceOptionnel;
import Projet_POO.Service.ServiceOptionnelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceOptionnelController {

    private final ServiceOptionnelService service;

    public ServiceOptionnelController(ServiceOptionnelService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceOptionnel creer(@RequestBody ServiceOptionnel s) {
        return service.creer(s);
    }

    @GetMapping
    public List<ServiceOptionnel> tous() {
        return service.tous();
    }

    @PostMapping("/depot")
    public ServiceDepotVehicule creerDepot(@RequestBody ServiceDepotVehicule s) {
        return (ServiceDepotVehicule) service.creer(s);
    }

    @PostMapping("/nettoyage")
    public ServiceNettoyage creerNettoyage(@RequestBody ServiceNettoyage s) {
        return (ServiceNettoyage) service.creer(s);
    }

    @PostMapping("/deverrouillage")
    public ServiceDeverrouillageMobile creerDeverrouillage(@RequestBody ServiceDeverrouillageMobile s) {
        return (ServiceDeverrouillageMobile) service.creer(s);
    }

}

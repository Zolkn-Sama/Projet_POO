package Projet_POO.Controller;

import Projet_POO.Domain.Entity.ServiceDeverrouillageMobile;
import Projet_POO.Service.ServiceDeverrouillageMobileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services-deverrouillage")
public class ServiceDeverrouillageMobileController {

    private final ServiceDeverrouillageMobileService service;

    public ServiceDeverrouillageMobileController(ServiceDeverrouillageMobileService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceDeverrouillageMobile> getAll() {
        return service.listerTous();
    }

    @PostMapping
    public ServiceDeverrouillageMobile creer(@RequestBody ServiceDeverrouillageMobile serviceDeverrouillage) {
        return service.sauvegarder(serviceDeverrouillage);
    }
}
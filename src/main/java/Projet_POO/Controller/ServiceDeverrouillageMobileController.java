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
<<<<<<< HEAD
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ServiceDeverrouillageMobile getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ServiceDeverrouillageMobile create(@RequestBody ServiceDeverrouillageMobile serviceDeverrouillageMobile) {
        return service.create(serviceDeverrouillageMobile);
    }

    @PutMapping("/{id}")
    public ServiceDeverrouillageMobile update(@PathVariable Long id, @RequestBody ServiceDeverrouillageMobile serviceDeverrouillageMobile) {
        return service.update(id, serviceDeverrouillageMobile);
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
    public ServiceDeverrouillageMobile creer(@RequestBody ServiceDeverrouillageMobile serviceDeverrouillage) {
        return service.sauvegarder(serviceDeverrouillage);
    }
}
>>>>>>> ALEX

package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projet_POO.Domain.Entity.ServiceDeverrouillageMobile;
import Projet_POO.Service.ServiceDeverrouillageMobileService;

@RestController
@RequestMapping("/services-deverrouillage")
public class ServiceDeverrouillageMobileController {

    private final ServiceDeverrouillageMobileService service;

    public ServiceDeverrouillageMobileController(ServiceDeverrouillageMobileService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceDeverrouillageMobile> getAll() {
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


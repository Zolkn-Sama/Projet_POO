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

import Projet_POO.Domain.Entity.ServiceNettoyage;
import Projet_POO.Service.ServiceNettoyageService;

@RestController
@RequestMapping("/services-nettoyage")
public class ServiceNettoyageController {

    private final ServiceNettoyageService service;

    public ServiceNettoyageController(ServiceNettoyageService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceNettoyage> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ServiceNettoyage getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ServiceNettoyage create(@RequestBody ServiceNettoyage serviceNettoyage) {
        return service.create(serviceNettoyage);
    }

    @PutMapping("/{id}")
    public ServiceNettoyage update(@PathVariable Long id, @RequestBody ServiceNettoyage serviceNettoyage) {
        return service.update(id, serviceNettoyage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

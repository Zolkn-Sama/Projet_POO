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

import Projet_POO.Domain.Entity.ServiceParking;
import Projet_POO.Service.ServiceParkingService;

@RestController
@RequestMapping("/services-parking")
public class ServiceParkingController {

    private final ServiceParkingService serviceParkingService;

    public ServiceParkingController(ServiceParkingService serviceParkingService) {
        this.serviceParkingService = serviceParkingService;
    }

    @GetMapping
    public List<ServiceParking> getAll() {
        return serviceParkingService.findAll();
    }

    @GetMapping("/{id}")
    public ServiceParking getById(@PathVariable Long id) {
        return serviceParkingService.findById(id);
    }

    @PostMapping
    public ServiceParking create(@RequestBody ServiceParking serviceParking) {
        return serviceParkingService.create(serviceParking);
    }

    @PutMapping("/{id}")
    public ServiceParking update(@PathVariable Long id,
                                 @RequestBody ServiceParking serviceParking) {
        return serviceParkingService.update(id, serviceParking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceParkingService.delete(id);
    }
}

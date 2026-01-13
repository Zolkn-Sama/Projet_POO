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

import Projet_POO.Domain.Entity.ServiceSignature;
import Projet_POO.Service.ServiceSignatureService;

@RestController
@RequestMapping("/services-signature")
public class ServiceSignatureController {

    private final ServiceSignatureService serviceSignatureService;

    public ServiceSignatureController(ServiceSignatureService serviceSignatureService) {
        this.serviceSignatureService = serviceSignatureService;
    }

    @GetMapping
    public List<ServiceSignature> getAll() {
        return serviceSignatureService.findAll();
    }

    @GetMapping("/{id}")
    public ServiceSignature getById(@PathVariable Long id) {
        return serviceSignatureService.findById(id);
    }

    @PostMapping
    public ServiceSignature create(@RequestBody ServiceSignature serviceSignature) {
        return serviceSignatureService.create(serviceSignature);
    }

    @PutMapping("/{id}")
    public ServiceSignature update(@PathVariable Long id,
                                   @RequestBody ServiceSignature serviceSignature) {
        return serviceSignatureService.update(id, serviceSignature);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceSignatureService.delete(id);
    }
}

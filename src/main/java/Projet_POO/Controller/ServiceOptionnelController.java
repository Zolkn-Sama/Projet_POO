package Projet_POO.Controller;

import Projet_POO.Domain.Entity.ServiceOptionnel;
import Projet_POO.Service.ServiceOptionnelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services-optionnels")
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
}

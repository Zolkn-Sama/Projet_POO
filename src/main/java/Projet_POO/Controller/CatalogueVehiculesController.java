package Projet_POO.Controller;

import Projet_POO.Domain.Entity.CatalogueVehicules;
import Projet_POO.Service.CatalogueVehiculesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue-vehicules")
public class CatalogueVehiculesController {

    private final CatalogueVehiculesService service;

    public CatalogueVehiculesController(CatalogueVehiculesService service) {
        this.service = service;
    }

    @PostMapping
    public CatalogueVehicules creer(@RequestBody CatalogueVehicules catalogue) {
        return service.creer(catalogue);
    }

    @GetMapping
    public List<CatalogueVehicules> toutes() {
        return service.toutes();
    }
}

package Projet_POO.Controller;

import Projet_POO.Domain.Entity.FiltreRecherche;
import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Service.CatalogueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {

    private final CatalogueService catalogueService;

    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @PostMapping("/recherche")
    public List<Vehicule> filtrer(@RequestBody FiltreRecherche filtre) {
        return catalogueService.rechercher(filtre);
    }
}
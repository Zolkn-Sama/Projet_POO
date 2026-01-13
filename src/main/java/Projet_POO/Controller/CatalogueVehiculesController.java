package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.FiltreRecherche;
import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Service.CatalogueVehiculesService;

@RestController
@RequestMapping("/catalogue")
public class CatalogueVehiculesController {

    private final CatalogueVehiculesService catalogueService;

    public CatalogueVehiculesController(CatalogueVehiculesService catalogueService) {
        this.catalogueService = catalogueService;
    }

    // Ajouter un véhicule existant (déjà en base) au catalogue
    @PostMapping("/vehicules/{vehiculeId}")
    public Vehicule ajouterVehicule(@PathVariable Long vehiculeId) {
        return catalogueService.ajouterVehiculeAuCatalogue(vehiculeId);
    }

    // Voir tout le catalogue
    @GetMapping("/vehicules")
    public List<Vehicule> getCatalogue() {
        return catalogueService.getVehiculesCatalogue();
    }

    // Filtrer les véhicules disponibles (selon ta classe FiltreRecherche)
    @PostMapping("/recherche")
    public List<Vehicule> rechercher(@RequestBody FiltreRecherche filtre) {
        return catalogueService.listerDisponibles(filtre);
    }

    // Retirer un véhicule du catalogue
    @DeleteMapping("/vehicules/{vehiculeId}")
    public void supprimerVehicule(@PathVariable Long vehiculeId) {
        catalogueService.supprimerVehiculeDuCatalogue(vehiculeId);
    }

    // Vider le catalogue
    @DeleteMapping
    public void viderCatalogue() {
        catalogueService.viderCatalogue();
    }
}

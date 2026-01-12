package Projet_POO.Service;

import Projet_POO.Domain.Entity.CatalogueVehicules;
import Projet_POO.Domain.Entity.FiltreRecherche;
import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Repository.CatalogueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {

    private final CatalogueRepository catalogueRepository;

    public CatalogueService(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public List<Vehicule> rechercher(FiltreRecherche filtre) {
        // On récupère les véhicules via le nouveau repository
        List<Vehicule> baseDonnees = catalogueRepository.findAll();

        // On utilise votre classe de logique CatalogueVehicules
        CatalogueVehicules catalogue = new CatalogueVehicules();
        for (Vehicule v : baseDonnees) {
            catalogue.ajouterVehicule(v);
        }

        return catalogue.listerDisponibles(filtre);
    }
}
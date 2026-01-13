package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Domain.Entity.FiltreRecherche;

public interface CatalogueVehiculesService {

    Vehicule ajouterVehiculeAuCatalogue(Long vehiculeId);

    List<Vehicule> getVehiculesCatalogue();

    List<Vehicule> listerDisponibles(FiltreRecherche filtre);

    void supprimerVehiculeDuCatalogue(Long vehiculeId);

    void viderCatalogue();
}

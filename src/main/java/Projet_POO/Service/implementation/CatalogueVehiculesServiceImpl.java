package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.CatalogueVehicules;
import Projet_POO.Domain.Entity.FiltreRecherche;
import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Repository.CatalogueVehiculesRepository;
import Projet_POO.Repository.VehiculeRepository;
import Projet_POO.Service.CatalogueVehiculesService;

@Service
public class CatalogueVehiculesServiceImpl implements CatalogueVehiculesService {

    private final CatalogueVehiculesRepository catalogueRepo;
    private final VehiculeRepository vehiculeRepository;

    // On réutilise ta classe CatalogueVehicules telle quelle (logique métier de filtre)
    private final CatalogueVehicules catalogue = new CatalogueVehicules();

    public CatalogueVehiculesServiceImpl(CatalogueVehiculesRepository catalogueRepo,
                                         VehiculeRepository vehiculeRepository) {
        this.catalogueRepo = catalogueRepo;
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public Vehicule ajouterVehiculeAuCatalogue(Long vehiculeId) {
        Vehicule v = vehiculeRepository.findById(vehiculeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule non trouvé"));

        // Ajout dans la classe métier + en mémoire
        catalogue.ajouterVehicule(v);
        catalogueRepo.save(v);

        return v;
    }

    @Override
    public List<Vehicule> getVehiculesCatalogue() {
        // Source de vérité: repository en mémoire
        return catalogueRepo.findAll();
    }

    @Override
    public List<Vehicule> listerDisponibles(FiltreRecherche filtre) {
        // On reconstruit la liste dans l’objet métier pour utiliser TA méthode listerDisponibles()
        CatalogueVehicules temp = new CatalogueVehicules();
        for (Vehicule v : catalogueRepo.findAll()) {
            temp.ajouterVehicule(v);
        }
        return temp.listerDisponibles(filtre);
    }

    @Override
    public void supprimerVehiculeDuCatalogue(Long vehiculeId) {
        if (!catalogueRepo.existsById(vehiculeId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule absent du catalogue");
        }
        catalogueRepo.deleteById(vehiculeId);
    }

    @Override
    public void viderCatalogue() {
        catalogueRepo.clear();
    }
}

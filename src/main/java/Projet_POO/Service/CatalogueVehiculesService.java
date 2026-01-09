package Projet_POO.Service;

import Projet_POO.Domain.Entity.CatalogueVehicules;
import Projet_POO.Repository.CatalogueVehiculesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueVehiculesService {

    private final CatalogueVehiculesRepository catalogueRepository;

    public CatalogueVehiculesService(CatalogueVehiculesRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public CatalogueVehicules creer(CatalogueVehicules catalogue) {
        return catalogueRepository.save(catalogue);
    }

    public List<CatalogueVehicules> toutes() {
        return catalogueRepository.findAll();
    }
}

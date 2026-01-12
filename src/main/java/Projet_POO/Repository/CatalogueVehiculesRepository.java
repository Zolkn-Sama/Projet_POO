package Projet_POO.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.Vehicule;

@Repository
public class CatalogueVehiculesRepository {

    // Stockage en mémoire du catalogue
    private final Map<Long, Vehicule> catalogue = new ConcurrentHashMap<>();

    public void save(Vehicule vehicule) {
        if (vehicule == null || vehicule.getId() == null) return;
        catalogue.put(vehicule.getId(), vehicule);
    }

    public List<Vehicule> findAll() {
        return new ArrayList<>(catalogue.values());
    }

    public boolean existsById(Long vehiculeId) {
        return vehiculeId != null && catalogue.containsKey(vehiculeId);
    }

    public void deleteById(Long vehiculeId) {
        if (vehiculeId != null) catalogue.remove(vehiculeId);
    }

    public void clear() {
        catalogue.clear();
    }
}

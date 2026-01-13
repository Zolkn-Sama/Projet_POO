package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Repository.VehiculeRepository;
import Projet_POO.Service.VehiculeService;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule findById(long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Véhicule non trouvé"));
    }

    @Override
    public Vehicule findByImmatriculation(String immatriculation) {
        return vehiculeRepository.findByImmatriculation(immatriculation)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Véhicule non trouvé"));
    }

    @Override
    public Vehicule create(Vehicule vehicule) {
        // Si ton id est auto-généré, tu peux forcer à null pour être sûr
        // vehicule.setId(null);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule update(Long id, Vehicule vehicule) {
        Vehicule existing = vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Véhicule non trouvé"));

        // Exemple si tu as ces propriétés :
        existing.setImmatriculation(vehicule.getImmatriculation());
        existing.setLocalisationVehicule(vehicule.getLocalisationVehicule());
        existing.setDeposeDifferenteAutorisee(vehicule.isDeposeDifferenteAutorisee());
        existing.setTypeVehicule(vehicule.getTypeVehicule());
        existing.setCaracteristiques(vehicule.getCaracteristiques());
        existing.setOptions(vehicule.getOptions());
        existing.setDisponibilites(vehicule.getDisponibilites());
        existing.setNotes(vehicule.getNotes());
        existing.setContrats(vehicule.getContrats());

        return vehiculeRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Véhicule non trouvé");
        }
        vehiculeRepository.deleteById(id);
    }
}

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
    public Vehicule findById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule non trouvé"));
    }

    @Override
    public Vehicule findByImmatriculation(String immatriculation) {
        return vehiculeRepository.findByImmatriculation(immatriculation)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule non trouvé"));
    }

    @Override
    public List<Vehicule> findByVilleDisponibilite(String ville) {
        return vehiculeRepository.findByVilleDisponibiliteIgnoreCase(ville);
    }

    @Override
    public Vehicule create(Vehicule vehicule) {
        // Pas de vehicule.setId(null) : ton entity n'a pas de setId()
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule update(Long id, Vehicule vehicule) {
        Vehicule existing = vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule non trouvé"));

        // Champs persistés (pas les @Transient)
        existing.setImmatriculation(vehicule.getImmatriculation());
        existing.setVilleDisponibilite(vehicule.getVilleDisponibilite());
        existing.setDeposeDifferenteAutorisee(vehicule.isDeposeDifferenteAutorisee());

        // Optionnel : si tu veux autoriser la mise à jour de certains transient (utile en mémoire)
        // existing.setTypeVehicule(vehicule.getTypeVehicule());
        // existing.setCaracteristiques(vehicule.getCaracteristiques());

        return vehiculeRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule non trouvé");
        }
        vehiculeRepository.deleteById(id);
    }
}

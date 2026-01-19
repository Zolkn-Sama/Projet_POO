package Projet_POO.Service.implementation;

import java.util.List;

import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Repository.VehiculeRepository; 
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import Projet_POO.Domain.Entity.NoteVehicule;
import Projet_POO.Repository.NoteVehiculeRepository;
import Projet_POO.Service.NoteVehiculeService;

@Service
public class NoteVehiculeServiceImpl implements NoteVehiculeService {

    private final NoteVehiculeRepository repo;
    private final VehiculeRepository vehiculeRepo; 

    public NoteVehiculeServiceImpl(NoteVehiculeRepository repo, VehiculeRepository vehiculeRepo) {
        this.repo = repo;
        this.vehiculeRepo = vehiculeRepo;
    }

    @Override
    public NoteVehicule creer(NoteVehicule note, Long vehiculeId) {

        // 1. Rechercher le véhicule en base de données
        Vehicule vehicule = vehiculeRepo.findById(vehiculeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule introuvable avec l'ID : " + vehiculeId));

        // 2. Lier le véhicule à la note
        note.setVehicule(vehicule);

        // 3. Initialiser l'ID à null pour forcer la création
        note.setId(null);

        // 4. Sauvegarder
        return repo.save(note);
    }

    @Override
    public List<NoteVehicule> toutes() {
        return repo.findAll();
    }

    @Override
    public List<NoteVehicule> parVehicule(Long vehiculeId) {
        List<NoteVehicule> notes = repo.findByVehiculeId(vehiculeId);

        if (notes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune note trouvée pour ce véhicule");
        }
        return notes;
    }
}

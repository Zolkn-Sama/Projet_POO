package Projet_POO.Service.implementation;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import Projet_POO.Domain.Entity.NoteVehicule;
import Projet_POO.Repository.NoteVehiculeRepository;
import Projet_POO.Service.NoteVehiculeService;

@Service
public class NoteVehiculeServiceImpl implements NoteVehiculeService {

    private final NoteVehiculeRepository repo;

    public NoteVehiculeServiceImpl(NoteVehiculeRepository repo) {
        this.repo = repo;
    }

    @Override
    public NoteVehicule creer(NoteVehicule note) {
        // Forcer l'ID à null pour assurer l'insertion SQL
        note.setId(null);
        return repo.save(note);
    }

    @Override
    public List<NoteVehicule> toutes() {
        return repo.findAll();
    }

    @Override
    public List<NoteVehicule> parVehicule(Long vehiculeId) {
        // Lève une exception 404 si la liste est vide (modèle AgentServiceImpl)
        List<NoteVehicule> notes = repo.findByVehiculeId(vehiculeId);
        if (notes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune évaluation trouvée pour ce véhicule");
        }
        return notes;
    }
}

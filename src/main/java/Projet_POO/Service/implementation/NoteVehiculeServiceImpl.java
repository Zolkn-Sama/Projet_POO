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

    private final NoteVehiculeRepository noteVehiculeRepository;

    public NoteVehiculeServiceImpl(NoteVehiculeRepository notevehiculerepository) {
        this.noteVehiculeRepository = notevehiculerepository;
    }

    @Override
    public List<NoteVehicule> getAll() {
        return noteVehiculeRepository.findAll();
    }

    @Override
    public NoteVehicule create(NoteVehicule note) {
        // Forcer l'ID à null pour assurer l'insertion SQL
        note.setId(null);
        return noteVehiculeRepository.save(note);
    }

    @Override
    public List<NoteVehicule> getByVehiculeId(Long id) {
        // Lève une exception 404 si la liste est vide (modèle AgentServiceImpl)
        List<NoteVehicule> notes = noteVehiculeRepository.findByVehiculeId(id);
        if (notes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune évaluation trouvée pour ce véhicule");
        }
        return notes;
    }
}

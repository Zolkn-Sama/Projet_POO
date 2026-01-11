package Projet_POO.Service;

import Projet_POO.Domain.Entity.NoteVehicule;
import Projet_POO.Repository.NoteVehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteVehiculeService {

    private final NoteVehiculeRepository repo;

    public NoteVehiculeService(NoteVehiculeRepository repo) {
        this.repo = repo;
    }

    public NoteVehicule creer(NoteVehicule note) {
        return repo.save(note);
    }

    public List<NoteVehicule> toutes() {
        return repo.findAll();
    }

    public List<NoteVehicule> parVehicule(Long vehiculeId) {
        return repo.findByVehiculeId(vehiculeId);
    }
}

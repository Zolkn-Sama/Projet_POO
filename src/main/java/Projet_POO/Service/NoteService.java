package Projet_POO.Service;

import Projet_POO.Domain.Entity.Note;
import Projet_POO.Repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository repo;

    public NoteService(NoteRepository repo) {
        this.repo = repo;
    }

    public Note creer(Note note) {
        return repo.save(note);
    }

    public List<Note> toutes() {
        return repo.findAll();
    }
}

package Projet_POO.Service.implementation;

import java.util.List;
import org.springframework.stereotype.Service;
import Projet_POO.Domain.Entity.Note;
import Projet_POO.Repository.NoteRepository;
import Projet_POO.Service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repo;

    /**
     * Injection du repository par constructeur selon le modèle AgentService.
     */
    public NoteServiceImpl(NoteRepository repo) {
        this.repo = repo;
    }

    @Override
    public Note creer(Note note) {
        // Garantir qu'il s'agit d'une création en forçant l'ID à null
        note.setId(null);
        return repo.save(note);
    }

    @Override
    public List<Note> toutes() {
        // Retourne la liste de toutes les entités Note
        return repo.findAll();
    }
}
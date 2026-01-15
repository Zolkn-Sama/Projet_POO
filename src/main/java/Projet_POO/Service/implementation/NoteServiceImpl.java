package Projet_POO.Service.implementation;

import java.util.List;
import org.springframework.stereotype.Service;
import Projet_POO.Domain.Entity.Note;
import Projet_POO.Domain.Entity.NoteCritere; // N'oubliez pas d'importer ceci
import Projet_POO.Repository.NoteRepository;
import Projet_POO.Service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repo;

    public NoteServiceImpl(NoteRepository repo) {
        this.repo = repo;
    }

    @Override
    public Note creer(Note note) {
        // 1. Forcer l'ID à null pour garantir qu'il s'agit d'une nouvelle création
        note.setId(null);

        // 2. 🟢 Programmation défensive : double vérification de l'association parent-enfant
        // Même si l'entité Note gère cela, il est plus sûr de le refaire ici.
        // Cela garantit que chaque "NoteCritere" sait à quelle "Note" il appartient.
        if (note.getCriteres() != null) {
            for (NoteCritere c : note.getCriteres()) {
                c.setNote(note); // Important : lier le critère à la note actuelle
            }
        }

        // 3. Sauvegarder
        // Grâce à CascadeType.ALL dans l'entité Note, cela sauvegardera à la fois
        // la Note et les NoteCritere associés.
        return repo.save(note);
    }

    @Override
    public List<Note> toutes() {
        // Retourne la liste de toutes les notes
        return repo.findAll();
    }
}
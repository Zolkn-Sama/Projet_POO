package Projet_POO.Service;

import Projet_POO.Domain.Entity.Note;
import java.util.List;

public interface NoteService {
    // Créer une nouvelle note
    Note creer(Note note);

    // Récupérer toutes les notes
    List<Note> toutes();
}
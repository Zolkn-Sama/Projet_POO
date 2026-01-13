package Projet_POO.Controller;

import Projet_POO.Domain.Entity.Note;
import Projet_POO.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    // On injecte l'interface NoteService
    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note create(@RequestBody Note note) {
        // Appelle la logique métier de l'implémentation
        return noteService.creer(note);
    }

    @GetMapping
    public List<Note> getAll() {
        return noteService.toutes();
    }
}
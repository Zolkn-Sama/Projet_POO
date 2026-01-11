package Projet_POO.Controller;

import Projet_POO.Domain.Entity.Note;
import Projet_POO.Service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @PostMapping
    public Note creer(@RequestBody Note note) {
        return service.creer(note);
    }

    @GetMapping
    public List<Note> toutes() {
        return service.toutes();
    }
}

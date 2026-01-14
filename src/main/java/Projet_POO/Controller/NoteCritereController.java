package Projet_POO.Controller;

import Projet_POO.Domain.Entity.NoteCritere;
import Projet_POO.Service.NoteCritereService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes-criteres")
public class NoteCritereController {

    private final NoteCritereService service;

    public NoteCritereController(NoteCritereService service) {
        this.service = service;
    }

    @GetMapping
    public List<NoteCritere> getAll() {
        return service.listerTous();
    }

    @PostMapping
    public NoteCritere creer(@RequestBody NoteCritere critere) {
        return service.sauvegarder(critere);
    }
}
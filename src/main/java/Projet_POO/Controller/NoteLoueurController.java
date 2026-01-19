package Projet_POO.Controller;

import Projet_POO.Domain.Entity.NoteLoueur;
import Projet_POO.Service.NoteLoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes-loueur")
public class NoteLoueurController {

    @Autowired
    private NoteLoueurService noteLoueurService;

    // Enregistre une évaluation pour un Loueur spécifique

    @PostMapping("/{loueurId}") 
    @ResponseStatus(HttpStatus.CREATED)
    public NoteLoueur create(@PathVariable Long loueurId, @RequestBody NoteLoueur note) {
        // On passe le contenu de la note (JSON) au service
        return noteLoueurService.creer(note, loueurId);
    }

    // Liste toutes les évaluations de tous les loueurs (Optionnel).

    @GetMapping
    public List<NoteLoueur> getAll() {
        return noteLoueurService.toutes();
    }

    // Récupère la liste des notes d'un loueur spécifique par son identifiant.

    @GetMapping("/loueur/{loueurId}")
    public List<NoteLoueur> getByLoueur(@PathVariable Long loueurId) {
        return noteLoueurService.parLoueur(loueurId);
    }
}

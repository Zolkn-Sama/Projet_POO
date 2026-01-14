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

    /**
     * Enregistre une évaluation pour un Loueur.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteLoueur create(@RequestBody NoteLoueur note) {
        return noteLoueurService.creer(note);
    }

    /**
     * Liste toutes les évaluations de véhicules.
     */
    @GetMapping
    public List<NoteLoueur> getAll() {
        return noteLoueurService.toutes();
    }

    /**
     * Récupère la liste des notes d'un véhicule par son identifiant.
     * La gestion d'erreur (404) est déléguée à la couche Service.
     */
    @GetMapping("/loueur/{loueurId}")
    public List<NoteLoueur> getByLoueur(@PathVariable Long loueurId) {
        return noteLoueurService.parLoueur(loueurId);
    }
}

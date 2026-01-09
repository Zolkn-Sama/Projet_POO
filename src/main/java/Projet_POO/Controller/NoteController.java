package Projet_POO.Controller;

import Projet_POO.Domain.Entity.Note;
import Projet_POO.Domain.Entity.NoteCritere;
import Projet_POO.Repository.NoteRepository;
import Projet_POO.Repository.NoteCritereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des notes.
 * Cette version retourne directement les données sans utiliser de fichiers HTML.
 */
@RestController // Changé de @Controller à @RestController pour afficher les données directement
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteCritereRepository noteCritereRepository;

    /**
     * Récupère toutes les notes et les affiche directement au format JSON dans le navigateur.
     * URL: http://localhost:8090/notes
     */
    @GetMapping
    public List<Note> listerToutesLesNotes() {
        // Retourne la liste des notes. Spring Boot convertit automatiquement en JSON.
        return noteRepository.findAll();
    }

    /**
     * Test de création d'une note avec critères pour vérifier le bon fonctionnement.
     * URL: http://localhost:8090/notes/test-split
     */
    @GetMapping("/test-split")
    public String testerEnregistrement() {
        // 1. Création d'une nouvelle note
        Note n = new Note("Test de retour direct sans HTML");
        noteRepository.save(n);

        // 2. Création d'un critère associé via son propre repository
        NoteCritere c = new NoteCritere("Facilité d'utilisation", 5);
        c.setNote(n);
        noteCritereRepository.save(c);

        return "Note enregistrée avec succès ! Actualisez http://localhost:8090/notes pour voir le JSON.";
    }

    /**
     * Ajoute un critère à une note existante via une requête POST.
     */
    @PostMapping("/{noteId}/criteres")
    public NoteCritere ajouterCritere(@PathVariable Long noteId, @RequestParam String nom, @RequestParam int valeur) {
        // Récupération de la note parente
        Note note = noteRepository.findById(noteId).orElseThrow();

        // Création et liaison du critère
        NoteCritere nouveauCritere = new NoteCritere(nom, valeur);
        nouveauCritere.setNote(note);

        // Retourne le critère créé pour confirmation
        return noteCritereRepository.save(nouveauCritere);
    }
}
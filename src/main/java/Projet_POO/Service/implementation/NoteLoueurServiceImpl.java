package Projet_POO.Service.implementation;

import java.util.List;

import Projet_POO.Domain.Entity.Loueur; // Import de l'entité Loueur
import Projet_POO.Repository.LoueurRepository; // Import du repo Loueur
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import Projet_POO.Domain.Entity.NoteLoueur;
import Projet_POO.Repository.NoteLoueurRepository;
import Projet_POO.Service.NoteLoueurService;

@Service
public class NoteLoueurServiceImpl implements NoteLoueurService {

    private final NoteLoueurRepository repo;
    private final LoueurRepository loueurRepo; // 🟢 Injection du Repository Loueur

    public NoteLoueurServiceImpl(NoteLoueurRepository repo, LoueurRepository loueurRepo) {
        this.repo = repo;
        this.loueurRepo = loueurRepo;
    }

    @Override
    public NoteLoueur creer(NoteLoueur note, Long loueurId) {

        // 1. Rechercher le Loueur dans sa propre table
        Loueur loueur = loueurRepo.findById(loueurId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur introuvable avec l'ID : " + loueurId));

        // 2. Lier l'entité Loueur à la Note
        note.setLoueur(loueur);

        // 3. Initialiser l'ID à null pour forcer la création
        note.setId(null);

        // 4. Sauvegarder
        return repo.save(note);
    }

    @Override
    public List<NoteLoueur> toutes() {
        return repo.findAll();
    }

    @Override
    public List<NoteLoueur> parLoueur(Long loueurId) {
        // Recherche via le repository
        List<NoteLoueur> notes = repo.findByLoueurId(loueurId);

        if (notes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune note trouvée pour ce loueur");
        }
        return notes;
    }
}
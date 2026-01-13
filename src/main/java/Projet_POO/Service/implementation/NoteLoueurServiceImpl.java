package Projet_POO.Service.implementation;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import Projet_POO.Domain.Entity.NoteLoueur;
import Projet_POO.Repository.NoteLoueurRepository;
import Projet_POO.Service.NoteLoueurService;

@Service
public class NoteLoueurServiceImpl implements NoteLoueurService {

    private final NoteLoueurRepository repo;

    public NoteLoueurServiceImpl(NoteLoueurRepository repo) {
        this.repo = repo;
    }

    @Override
    public NoteLoueur creer(NoteLoueur note) {
        // Garantir une nouvelle création en forçant l'ID à null
        note.setId(null);
        return repo.save(note);
    }

    @Override
    public List<NoteLoueur> toutes() {
        return repo.findAll();
    }

    @Override
    public List<NoteLoueur> parLoueur(Long loueurId) {
        // Recherche par ID de Louer avec gestion d'erreur (modèle AgentServiceImpl)
        List<NoteLoueur> notes = repo.findByLoueurId(loueurId);
        if (notes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune note trouvée pour cet loueur");
        }
        return notes;
    }
}
package Projet_POO.Service;

import Projet_POO.Domain.Entity.NoteLoueur;
import java.util.List;

public interface NoteLoueurService {
    // Créer une nouvelle note pour un agent
    NoteLoueur creer(NoteLoueur note);

    // Récupérer la liste de toutes les notes des agents
    List<NoteLoueur> toutes();

    // Filtrer les notes par l'identifiant de l'agent
    List<NoteLoueur> parLoueur(Long loueurId);
}

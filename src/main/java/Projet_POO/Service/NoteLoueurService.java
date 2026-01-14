package Projet_POO.Service;

import Projet_POO.Domain.Entity.NoteLoueur;
import java.util.List;

public interface NoteLoueurService {
    // Création d'une note liée à un Loueur spécifique
    NoteLoueur creer(NoteLoueur note, Long loueurId);

    List<NoteLoueur> toutes();
    List<NoteLoueur> parLoueur(Long loueurId);
}

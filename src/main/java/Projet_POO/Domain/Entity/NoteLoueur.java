package Projet_POO.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "note_loueur")
@PrimaryKeyJoinColumn(name = "id") // Lien vers la clé primaire de la table parente 'note'
public class NoteLoueur extends Note {

    // 🟢 CHANGEMENT : Relation directe vers l'entité Loueur
    @ManyToOne
    @JoinColumn(name = "loueur_id", nullable = false)
    @JsonIgnore // ⚠️ Empêche la récursion infinie dans le JSON
    private Loueur loueur;

    public NoteLoueur() {
        super();
    }

    public NoteLoueur(String commentaire, Loueur loueur) {
        super(commentaire);
        this.loueur = loueur;
    }

    // Getters et Setters typés avec Loueur
    public Loueur getLoueur() {
        return loueur;
    }

    public void setLoueur(Loueur loueur) {
        this.loueur = loueur;
    }
}
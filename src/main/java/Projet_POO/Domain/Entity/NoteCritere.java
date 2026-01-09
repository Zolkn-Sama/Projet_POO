package Projet_POO.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Entité représentant un critère spécifique d'une évaluation.
 */
@Entity
@Table(name = "note_criteres")
public class NoteCritere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique pour AlwaysData

    private String nom;
    private int valeur; // Score attribué (ex: de 1 à 5)

    // Relation Plusieurs-à-Un : Plusieurs critères appartiennent à une seule Note
    // On utilise FetchType.LAZY pour optimiser les performances
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_id") // Crée la colonne de clé étrangère dans la base de données
    @JsonIgnore // Ajoute ceci pour éviter la boucle infinie lors de l'affichage JSON
    private Note note;

    // Constructeur par défaut requis par JPA/Hibernate
    public NoteCritere() {}

    // Constructeur pratique pour créer un critère rapidement
    public NoteCritere(String nom, int valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }

    // --- Getters et Setters ---

    public Long getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getValeur() { return valeur; }
    public void setValeur(int valeur) { this.valeur = valeur; }

    public Note getNote() { return note; }
    public void setNote(Note note) { this.note = note; }
}
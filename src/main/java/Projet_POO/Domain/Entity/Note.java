package Projet_POO.Domain.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notes") // Nom de la table sur AlwaysData
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Utilisation de Long pour la compatibilité JpaRepository

    private LocalDateTime date;

    @Column(columnDefinition = "TEXT")
    private String commentaire;

    // Relation Un-à-Plusieurs avec NoteCritere
    // mappedBy indique que l'autre côté (NoteCritere) gère la relation
    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoteCritere> criteres = new ArrayList<>();

    // Constructeur par défaut requis par JPA
    public Note() {
        this.date = LocalDateTime.now();
    }

    // Constructeur pour faciliter la création
    public Note(String commentaire) {
        this();
        this.commentaire = commentaire;
    }

    /**
     * Calcule la moyenne de tous les critères associés.
     * @return 0.0 si aucun critère, sinon la moyenne.
     */
    public double noteGlobale() {
        if (criteres == null || criteres.isEmpty()) {
            return 0.0;
        }
        double somme = 0.0;
        for (NoteCritere c : criteres) {
            somme += c.getValeur();
        }
        return somme / criteres.size();
    }

    // --- Getters et Setters ---

    public Long getId() { return id; }

    public LocalDateTime getDate() { return date; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }

    public List<NoteCritere> getCriteres() { return criteres; }

    /**
     * Ajoute un critère et assure la liaison bidirectionnelle pour JPA.
     */
    public void ajouterCritere(NoteCritere critere) {
        if (critere != null) {
            criteres.add(critere);
            critere.setNote(this); // Indispensable pour que note_id soit rempli en base
        }
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", date=" + date +
                ", commentaire='" + commentaire + '\'' +
                ", noteGlobale=" + noteGlobale() +
                '}';
    }
}
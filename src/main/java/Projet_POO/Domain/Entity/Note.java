package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "note")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @Column(length = 1000)
    private String commentaire;

    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoteCritere> criteres = new ArrayList<>();

    private String reponse;
    private java.time.LocalDateTime dateReponse;

    public Note() {
        this.date = LocalDateTime.now();
    }

    public Note(String commentaire) {
        this();
        this.commentaire = commentaire;
    }
    public String getReponse() { return reponse; }
    public void setReponse(String reponse) { this.reponse = reponse; }

    public LocalDateTime getDateReponse() { return dateReponse; }
    public void setDateReponse(LocalDateTime dateReponse) { this.dateReponse = dateReponse; }

    public Long getId() { return id; }

    public LocalDateTime getDate() { return date; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }

    public List<NoteCritere> getCriteres() {
        return new ArrayList<>(criteres);
    }

    public void ajouterCritere(NoteCritere critere) {
        if (critere == null) return;
        critere.setNote(this);          // lien inverse 
        criteres.add(critere);
    }

    public void supprimerCritere(NoteCritere critere) {
        if (critere == null) return;
        criteres.remove(critere);
        critere.setNote(null);
    }

    @Transient
    public double noteGlobale() {
        if (criteres.isEmpty()) return 0.0;
        double somme = 0.0;
        for (NoteCritere c : criteres) somme += c.getValeur();
        return somme / criteres.size();
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

    public void setCriteres(List<NoteCritere> criteres) {
        this.criteres.clear();
        if (criteres == null) return;
        for (NoteCritere c : criteres) {
            this.ajouterCritere(c); 
        }
    }

    public void setId(Long id) {
        this.id = id;
    }
}


package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class Note {

    private int id;
    private LocalDateTime date;
    private String commentaire;
    private List<NoteCritere> criteres;

    public Note(int id, LocalDateTime date ,String commentaire) {
        this.id = id;
        this.date = LocalDateTime.now();
        this.commentaire = commentaire;
        this.criteres = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void ajouterCritere(NoteCritere critere) {
        if (critere != null) {
            criteres.add(critere);
        }
    }

    public List<NoteCritere> getCriteres() {
        return new ArrayList<>(criteres);
    }

    /**
     * noteGlobale(): moyenne des valeurs des critères.
     * Si aucun critère, on retourne 0.0.
     */
    public double noteGlobale() {
        if (criteres.isEmpty()) {
            return 0.0;
        }
        double somme = 0.0;
        for (NoteCritere c : criteres) {
            somme += c.getValeur();
        }
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
}

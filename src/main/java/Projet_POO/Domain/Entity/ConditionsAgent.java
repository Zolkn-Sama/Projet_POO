package Projet_POO.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "conditions_agent")
public class ConditionsAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean chienAutorise;
    private boolean fumerAutorise;
    private String commentaire;

    public ConditionsAgent() {
    }

    public ConditionsAgent(boolean chienAutorise, boolean fumerAutorise, String commentaire) {
        this.chienAutorise = chienAutorise;
        this.fumerAutorise = fumerAutorise;
        this.commentaire = commentaire;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isChienAutorise() { return chienAutorise; }
    public void setChienAutorise(boolean chienAutorise) { this.chienAutorise = chienAutorise; }

    public boolean isFumerAutorise() { return fumerAutorise; }
    public void setFumerAutorise(boolean fumerAutorise) { this.fumerAutorise = fumerAutorise; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }

    @Override
    public String toString() {
        return "ConditionsAgent{" +
                "id=" + id +
                ", chienAutorise=" + chienAutorise +
                ", fumerAutorise=" + fumerAutorise +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
package Projet_POO.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "note_loueur")
public class NoteLoueur extends Note {

    private Long agentId;

    public NoteLoueur() { super(); }

    public NoteLoueur(String commentaire, Long agentId) {
        super(commentaire);
        this.agentId = agentId;
    }

    public Long getLoueurId() { return agentId; }
    public void setLoueurId(Long agentId) { this.agentId = agentId; }
}


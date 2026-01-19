package Projet_POO.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "note_agent")
@PrimaryKeyJoinColumn(name = "id") // Lien vers la clé primaire de la table parente 'note'
public class NoteAgent extends Note {

    // Relation objet au lieu d'un simple ID 
    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    @JsonIgnore // Empêche la boucle infinie dans le JSON 
    private Agent agent;

    public NoteAgent() {
        super();
    }

    public NoteAgent(String commentaire, Agent agent) {
        super(commentaire);
        this.agent = agent;
    }

    // Getters et Setters
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}

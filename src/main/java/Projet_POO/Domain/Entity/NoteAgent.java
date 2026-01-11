package Projet_POO.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "note_agent")
public class NoteAgent extends Note {

    private Long agentId;

    public NoteAgent() { super(); }

    public NoteAgent(String commentaire, Long agentId) {
        super(commentaire);
        this.agentId = agentId;
    }

    public Long getAgentId() { return agentId; }
    public void setAgentId(Long agentId) { this.agentId = agentId; }
}

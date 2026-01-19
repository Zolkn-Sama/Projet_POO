package Projet_POO.Domain.Entity;

import  java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private LocalDateTime dateCreation;

    private Long loueurId;

    private Long agentId; 

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    public Conversation() {
        this.dateCreation = LocalDateTime.now();
    }

    public Conversation(String nom, Long loueurId, Long agentId) {
        this();
        this.nom = nom;
        this.dateCreation = LocalDateTime.now();
        this.loueurId = loueurId;
        this.agentId = agentId;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public Long getLoueurId() {
        return loueurId;
    }

    public void setLoueurId(Long loueurId) {
        this.loueurId = loueurId;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

}

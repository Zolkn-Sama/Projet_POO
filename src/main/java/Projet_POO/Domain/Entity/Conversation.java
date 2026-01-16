package Projet_POO.Domain.Entity;

import  java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loueur_id")
    private Loueur loueur; // id du loueur auteur

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private Agent agent; // id de l'agent 

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    public Conversation() {
        this.dateCreation = LocalDateTime.now();
    }

    public Conversation(String nom, Loueur loueur, Agent agent) {
        this();
        this.nom = nom;
        this.dateCreation = LocalDateTime.now();
        this.loueur = loueur;
        this.agent = agent;
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

    public Loueur getLoueur() {
        return loueur;
    }

    public void setLoueur(Loueur loueur) {
        this.loueur = loueur;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}

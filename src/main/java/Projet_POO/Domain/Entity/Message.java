package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long utilisateurId;

    private LocalDateTime dateMessage;

    @Column(length = 2000)
    private String contenu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversation_id")
    @JsonIgnore
    private Conversation conversation;

    public Message() {
        this.dateMessage = LocalDateTime.now();
    }

    public Message(Long utilisateurId, String contenu) {
        this();
        this.utilisateurId = utilisateurId;
        this.contenu = contenu;
        this.dateMessage = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public LocalDateTime getDateMessage() {
        return dateMessage;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }
}

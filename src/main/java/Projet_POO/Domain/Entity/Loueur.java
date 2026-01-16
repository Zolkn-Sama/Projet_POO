package Projet_POO.Domain.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "loueur")
public class Loueur {

    @Id
    private Long id; // même id que Utilisateur

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;


    @Transient
    @JsonIgnore
    private List<ContratLocation> locations = new ArrayList<>();

    @Transient
    @JsonIgnore
    private List<Note> notesRecues = new ArrayList<>();

    @OneToMany(mappedBy = "loueur", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Conversation> conversations = new ArrayList<>();

    public Loueur() {
    }

    public Loueur(long id) {
        this.id = utilisateur.getId();
    }

    public Loueur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        this.id = utilisateur.getId();
    }

    // --------- MÉTHODES MÉTIER ---------
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }


    public void ajouterLocation(ContratLocation contrat) {
        if (contrat != null)
            locations.add(contrat);
    }

    public List<ContratLocation> consulterLocations() {
        return new ArrayList<>(locations);
    }

    public void modifierProfil(Utilisateur p) {
        if (p == null)
            return;

        this.getUtilisateur().setNom(p.getNom());
        this.getUtilisateur().setPrenom(p.getPrenom());
        this.getUtilisateur().setEmail(p.getEmail());
        this.getUtilisateur().setTelephone(p.getTelephone());
        this.getUtilisateur().setLocalisationUtilisateur(p.getLocalisationUtilisateur());
        this.getUtilisateur().setDateNaissance(p.getDateNaissance());
        this.getUtilisateur().setNumeroPermis(p.getNumeroPermis());
        this.getUtilisateur().setDateObtentionPermis(p.getDateObtentionPermis());
    }

    public void noterAgent(Agent a, Note note) {
        if (a == null || note == null)
            return;
        a.ajouterNote(note);
    }

    public void ajouterNoteRecue(Note note) {
        if (note != null)
            notesRecues.add(note);
    }

    public List<Note> getNotesRecues() {
        return new ArrayList<>(notesRecues);
    }

    @Override
    public String toString() {
        return "Loueur{" +
                "id=" + getId() +
                ", nom='" + getUtilisateur().getNom() + '\'' +
                ", prenom='" + getUtilisateur().getPrenom() + '\'' +
                ", email='" + getUtilisateur().getEmail() + '\'' +
                '}';
    }

}

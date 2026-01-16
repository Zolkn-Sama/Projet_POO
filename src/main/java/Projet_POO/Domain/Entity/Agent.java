package Projet_POO.Domain.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
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
@Table(name = "agent")
public class Agent {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    private boolean estProfessionnel;

    // Tant que ConditionsAgent n’est pas une @Entity ou @Embeddable, on la met en Transient

    @Embedded
    private ConditionsAgent conditions;

    // Tant que Vehicule et Note ne sont pas reliés via @OneToMany/@ManyToMany, on laisse Transient
    @OneToMany(mappedBy = "agent", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Vehicule> vehicules = new ArrayList<>();

    @OneToMany(mappedBy = "agent", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Conversation> conversations = new ArrayList<>();

    @Transient
    private List<Note> notesRecues = new ArrayList<>();

    public Agent() {
    }

    public Agent(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        this.id = utilisateur.getId();
    }

    public Agent(Utilisateur utilisateur,
                boolean estProfessionnel,
                ConditionsAgent conditions) {
        this.utilisateur = utilisateur;
        this.id = utilisateur.getId();
        this.estProfessionnel = estProfessionnel;
        this.conditions = conditions;
    }

    // ----- getters / setters -----

    
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

    public boolean isEstProfessionnel() {
        return estProfessionnel;
    }

    public void setEstProfessionnel(boolean estProfessionnel) {
        this.estProfessionnel = estProfessionnel;
    }

    public ConditionsAgent getConditions() {
        return conditions;
    }

    public void setConditions(ConditionsAgent conditions) {
        this.conditions = conditions;
    }


    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public List<Note> getNotesRecues() {
        return new ArrayList<>(notesRecues);
    }

    // ----- méthodes métier importantes -----

    public void ajouterVehicule(Vehicule v) {
        if (v != null && !vehicules.contains(v)) {
            vehicules.add(v);
        }
    }

    public void retirerVehicule(Vehicule v) {
        if (v != null) {
            vehicules.remove(v);
        }
    }

    /** Méthode appelée par Loueur.noterAgent */
    public void ajouterNote(Note note) {
        if (note != null) {
            notesRecues.add(note);
        }
    }

    public HistoriqueVehicule consulterHistorique(Vehicule v) {
        if (v == null || !vehicules.contains(v)) {
            return null;
        }
        // Attention: v.getContrats() doit exister dans Vehicule (version d’hier OK)
        return new HistoriqueVehicule(v, v.getContrats());
    }


    
    @Override
    public String toString() {
        return "Agent{" +
                "id=" + getId() +
                ", nom='" + getUtilisateur().getNom() + '\'' +
                ", prenom='" + getUtilisateur().getPrenom() + '\'' +
                ", email='" + getUtilisateur().getEmail() + '\'' +
                ", estProfessionnel=" + estProfessionnel +
                '}';
    }

}

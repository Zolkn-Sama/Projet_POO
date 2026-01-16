package Projet_POO.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "loueur")

public class Loueur extends Utilisateur {

    @Transient
    @JsonIgnore
    private List<ContratLocation> locations = new ArrayList<>();

    @Transient
    @JsonIgnore
    private List<Note> notesRecues = new ArrayList<>();

    public Loueur() {
        super();
    }

    public Loueur(Long id,
            String nom,
            String prenom,
            String password,
            String email,
            String telephone,
            String rue,
            String ville,
            String pays,
            LocalDate dateNaissance,
            String numeroPermis,
            LocalDate dateObtentionPermis,
                  double solde) {

        super(id, nom, prenom, password, email,
                telephone, rue, ville, pays,
                dateNaissance, numeroPermis, dateObtentionPermis, solde);
    }

    // --------- MÉTHODES MÉTIER ---------

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

        this.setNom(p.getNom());
        this.setPrenom(p.getPrenom());
        this.setEmail(p.getEmail());
        this.setTelephone(p.getTelephone());
        this.setRue(p.getRue());
        this.setVille(p.getVille());
        this.setPays(p.getPays());
        this.setDateNaissance(p.getDateNaissance());
        this.setNumeroPermis(p.getNumeroPermis());
        this.setDateObtentionPermis(p.getDateObtentionPermis());
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
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }


}

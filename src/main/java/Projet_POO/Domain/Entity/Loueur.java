package Projet_POO.Domain.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Loueur extends Utilisateur {

    // Les contrats de location de ce loueur
    private List<ContratLocation> locations;

    // Les notes que le loueur reçoit (noté par les agents)
    private List<Note> notesRecues;

    // --------- CONSTRUCTEURS ---------

    public Loueur() {
        super();
        this.locations = new ArrayList<>();
        this.notesRecues = new ArrayList<>();
    }

    public Loueur(int id,
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
                  LocalDate dateObtentionPermis) {

        // on réutilise le constructeur complet d'Utilisateur
        super(id, nom, prenom, password, email,
              telephone, rue, ville, pays,
              dateNaissance, numeroPermis, dateObtentionPermis);

        this.locations = new ArrayList<>();
        this.notesRecues = new ArrayList<>();
    }

    // --------- MÉTHODES DU LOUeur (liées au métier) ---------

    /**
     * Ajouter un contrat à la liste des locations du loueur.
     * À appeler quand un nouveau contrat est créé pour ce loueur.
     */
    public void ajouterLocation(ContratLocation contrat) {
        if (contrat != null) {
            locations.add(contrat);
        }
    }

    /**
     * consulterLocations() : renvoie la liste des contrats de ce loueur.
     * (copie de la liste interne pour éviter de la modifier de l’extérieur)
     */
    public List<ContratLocation> consulterLocations() {
        return new ArrayList<>(locations);
    }

    /**
     * modifierProfil(p : Utilisateur)
     * Met à jour les infos du loueur à partir d'un autre objet Utilisateur.
     * On NE change pas l'id ni le mot de passe ici.
     */
    public void modifierProfil(Utilisateur p) {
        if (p == null) return;

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

    /**
     * noterVehicule(v : Vehicule, note : Note)
     * Le loueur laisse une note à un véhicule.
     * On délègue au véhicule qui garde la liste de ses notes.
     */
    public void noterVehicule(Vehicule v, Note note) {
        if (v == null || note == null) return;
        v.ajouterNote(note);
    }

    /**
     * noterAgent(a : Agent, note : Note)
     * Le loueur laisse une note à un agent.
     * On délègue à l'agent qui garde ses notes reçues.
     */
    public void noterAgent(Agent a, Note note) {
        if (a == null || note == null) return;
        a.ajouterNote(note);
    }

    /**
     * Ajouter une note reçue par ce loueur (quand un agent le note).
     */
    public void ajouterNoteRecue(Note note) {
        if (note != null) {
            notesRecues.add(note);
        }
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
                ", nbLocations=" + locations.size() +
                ", nbNotesRecues=" + notesRecues.size() +
                '}';
    }
}

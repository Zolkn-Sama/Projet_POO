package Projet_POO.Domain.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Agent extends Utilisateur {

    private boolean estProfessionnel;
    private ConditionsAgent conditions;
    private List<Vehicule> vehicules;
    private List<Note> notesRecues;  // ⬅ notes que l’agent reçoit

    public Agent() {
        super();
        this.vehicules = new ArrayList<>();
        this.notesRecues = new ArrayList<>();
    }

    public Agent(int id,
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
                 boolean estProfessionnel,
                 ConditionsAgent conditions) {

        super(id, nom, prenom, password, email,
              telephone, rue, ville, pays,
              dateNaissance, numeroPermis, dateObtentionPermis);

        this.estProfessionnel = estProfessionnel;
        this.conditions = conditions;
        this.vehicules = new ArrayList<>();
        this.notesRecues = new ArrayList<>();
    }


    /* Méthode appelée par Loueur.noterAgent */
    public void ajouterNote(Note note) {
        if (note != null) {
            notesRecues.add(note);
        }
    }

    public List<Note> getNotesRecues() {
        return new ArrayList<>(notesRecues);
    }
    public HistoriqueVehicule consulterHistorique(Vehicule v) {
        if (v == null || !vehicules.contains(v)) {
            return null; 
        }
        return new HistoriqueVehicule(v, v.getContrats());
    }

}

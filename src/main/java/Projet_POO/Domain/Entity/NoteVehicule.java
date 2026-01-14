package Projet_POO.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "note_vehicule")
@PrimaryKeyJoinColumn(name = "id") // Lien vers la clé primaire de la table parente 'note'
public class NoteVehicule extends Note {

    @ManyToOne
    @JoinColumn(name = "vehicule_id", nullable = false)
    @JsonIgnore // ⚠️ IMPORTANT : Empêche la boucle infinie dans le JSON (Swagger)
    private Vehicule vehicule;

    public NoteVehicule() {
        super();
    }

    public NoteVehicule(String commentaire, Vehicule vehicule) {
        super(commentaire);
        this.vehicule = vehicule;
    }

    // Getters et Setters
    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
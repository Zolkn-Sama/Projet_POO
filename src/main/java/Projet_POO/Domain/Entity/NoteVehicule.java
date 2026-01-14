package Projet_POO.Domain.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "note_vehicule")
public class NoteVehicule extends Note {

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule; // On utilise l'objet Vehicule

    public NoteVehicule() { super(); }

    // Modifiez le constructeur pour accepter l'objet Vehicule
    public NoteVehicule(String commentaire, Vehicule vehicule) {
        super(commentaire);
        this.vehicule = vehicule;
    }

    public Vehicule getVehicule() { return vehicule; }
    public void setVehicule(Vehicule vehicule) { this.vehicule = vehicule; }

    // Supprimez l'ancien getVehiculeId() et setVehiculeId() car ils causent l'erreur
}
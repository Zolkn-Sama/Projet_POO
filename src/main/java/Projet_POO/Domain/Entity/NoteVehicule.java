package Projet_POO.Domain.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "note_vehicule")
public class NoteVehicule extends Note {

    private Long vehiculeId;

    public NoteVehicule() { super(); }

    public NoteVehicule(String commentaire, Long vehiculeId) {
        super(commentaire);
        this.vehiculeId = vehiculeId;
    }

    public Long getVehiculeId() { return vehiculeId; }
    public void setVehiculeId(Long vehiculeId) { this.vehiculeId = vehiculeId; }
}

package Projet_POO.Domain.Entity;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
>>>>>>> ALEX

@Entity
@Table(name = "couverture_assurance")
public class CouvertureAssurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Long id;
=======
    private int id;
>>>>>>> ALEX

    private String libelle;
    private double plafond;
    private double franchise;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "assurance_id")
    private Assurance assurance;

    public CouvertureAssurance() {}

    public CouvertureAssurance(String libelle, double plafond, double franchise) {
        this.libelle = libelle;
        this.plafond = plafond;
        this.franchise = franchise;
    }

<<<<<<< HEAD
    public Long getId() { return id; }
=======
    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
>>>>>>> ALEX

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public double getPlafond() { return plafond; }
    public void setPlafond(double plafond) { this.plafond = plafond; }

    public double getFranchise() { return franchise; }
    public void setFranchise(double franchise) { this.franchise = franchise; }

<<<<<<< HEAD
    public Assurance getAssurance() { return assurance; }
    public void setAssurance(Assurance assurance) { this.assurance = assurance; }
}
=======
    @Override
    public String toString() {
        return "CouvertureAssurance{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", plafond=" + plafond +
                ", franchise=" + franchise +
                '}';
    }
}
>>>>>>> ALEX

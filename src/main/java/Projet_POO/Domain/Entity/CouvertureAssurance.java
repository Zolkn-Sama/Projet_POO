package Projet_POO.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "couverture_assurance")
public class CouvertureAssurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() { return id; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public double getPlafond() { return plafond; }
    public void setPlafond(double plafond) { this.plafond = plafond; }

    public double getFranchise() { return franchise; }
    public void setFranchise(double franchise) { this.franchise = franchise; }

    public Assurance getAssurance() { return assurance; }
    public void setAssurance(Assurance assurance) { this.assurance = assurance; }
}
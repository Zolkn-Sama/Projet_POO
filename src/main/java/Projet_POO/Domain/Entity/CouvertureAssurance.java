package Projet_POO.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "couverture_assurance")
public class CouvertureAssurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String libelle;
    private double plafond;
    private double franchise;

    public CouvertureAssurance() { }

    public CouvertureAssurance(int id, String libelle, double plafond, double franchise) {
        this.id = id;
        this.libelle = libelle;
        this.plafond = plafond;
        this.franchise = franchise;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public double getPlafond() { return plafond; }
    public void setPlafond(double plafond) { this.plafond = plafond; }

    public double getFranchise() { return franchise; }
    public void setFranchise(double franchise) { this.franchise = franchise; }

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
package Projet_POO.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "service_optionnel")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
public class ServiceOptionnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private double prix;

    public ServiceOptionnel() {}

    public ServiceOptionnel(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
}

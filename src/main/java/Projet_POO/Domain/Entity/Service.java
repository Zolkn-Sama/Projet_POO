package Projet_POO.Domain.Entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "service")
public abstract class Service {   // abstract 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private double prix;

    // Constructeur 
    public Service() {}

    // Constructeur 
    public Service(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // Constructeur utilisé par ServiceSignature
    public Service(Long id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    protected abstract Double CalculerPrix(Vehicule vehicule);

    // Getters / setters
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) {  
        this.id = id;
    }

    public String getNom() { 
        return nom; 
    }

    public void setNom(String nom) { 
        this.nom = nom; 
    }

    public double getPrix() { 
        return prix; 
    }

    public void setPrix(double prix) { 
        this.prix = prix; 
    }
}


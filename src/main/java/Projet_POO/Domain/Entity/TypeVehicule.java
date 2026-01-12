package Projet_POO.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_vehicule")
public class TypeVehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String libelle; // ex : Voiture, Bateau, Avion...
    private String domaine; // DomaineDeplacement

    // ✅ CONSTRUCTEUR VIDE OBLIGATOIRE POUR JPA/HIBERNATE
    public TypeVehicule() {
    }

    public TypeVehicule(int id, String libelle, String domaine) {
        this.id = id;
        this.libelle = libelle;
        this.domaine = domaine;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public String getDomaine() { return domaine; }
    public void setDomaine(String domaine) { this.domaine = domaine; }
}
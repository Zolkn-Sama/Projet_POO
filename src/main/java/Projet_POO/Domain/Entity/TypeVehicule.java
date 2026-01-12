package Projet_POO.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "type_vehicule")
public class TypeVehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;   // Voiture, Moto...
    private String domaine;   // DomaineDeplacement en String (ok pour le moment)

    public TypeVehicule() {}

    public TypeVehicule(String libelle, String domaine) {
        this.libelle = libelle;
        this.domaine = domaine;
    }

    public Long getId() { return id; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public String getDomaine() { return domaine; }
    public void setDomaine(String domaine) { this.domaine = domaine; }
}

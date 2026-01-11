package Projet_POO.Domain.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_deverrouillage")
@PrimaryKeyJoinColumn(name = "id")
public class ServiceDeverrouillageMobile extends ServiceOptionnel {

    private String fournisseur;

    public ServiceDeverrouillageMobile() { super(); }

    public ServiceDeverrouillageMobile(String nom, double prix, String fournisseur) {
        super(nom, prix);
        this.fournisseur = fournisseur;
    }

    public String getFournisseur() { return fournisseur; }
    public void setFournisseur(String fournisseur) { this.fournisseur = fournisseur; }
}

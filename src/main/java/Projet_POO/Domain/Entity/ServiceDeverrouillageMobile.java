package Projet_POO.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_deverrouillage")
@PrimaryKeyJoinColumn(name = "id")
public class ServiceDeverrouillageMobile extends Service {

    private final float serviceFees = 0.02f;
    private String fournisseur;

    public ServiceDeverrouillageMobile() { super(); }

    public ServiceDeverrouillageMobile(Long id, String nom, double prix, String fournisseur) {
        super(id, nom, prix);
        this.fournisseur = fournisseur;
    }

    public String getFournisseur() { return fournisseur; }
    public void setFournisseur(String fournisseur) { this.fournisseur = fournisseur; }

    @Override
    protected Double CalculerPrix(Vehicule v) {
        return v.getPrixJournalier() * serviceFees;
    }
}

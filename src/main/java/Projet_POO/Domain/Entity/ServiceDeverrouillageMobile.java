package Projet_POO.Domain.Entity;

public class ServiceDeverrouillageMobile extends ServiceOptionnel {

    private String fournisseur;

    public ServiceDeverrouillageMobile() { }

    public ServiceDeverrouillageMobile(long id, String nom, double prix,
                                       String fournisseur) {
        super(id, nom, prix);
        this.fournisseur = fournisseur;
    }

    public String getFournisseur() { return fournisseur; }

    public void setFournisseur(String fournisseur) { this.fournisseur = fournisseur; }

    @Override
    public String toString() {
        return "ServiceDeverrouillageMobile{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", prix=" + getPrix() +
                ", fournisseur='" + fournisseur + '\'' +
                '}';
    }
}

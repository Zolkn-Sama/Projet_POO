package Projet_POO.Domain.Entity;

public class ServiceOptionnel {

    private int id;
    private String nom;
    private double prix; // par contrat

    public ServiceOptionnel() { }

    public ServiceOptionnel(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public double getPrix() { return prix; }

    public void setPrix(double prix) { this.prix = prix; }

    @Override
    public String toString() {
        return "ServiceOptionnel{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}

package Projet_POO.Domain.Entity;


public class NoteCritere {

    private int id;
    private String nom;
    private int valeur;  // par ex. de 1 à 5

    public NoteCritere(int id, String nom, int valeur) {
        this.id = id;
        this.nom = nom;
        this.valeur = valeur;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}

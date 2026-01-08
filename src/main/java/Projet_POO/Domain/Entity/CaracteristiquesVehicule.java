package Projet_POO.Domain.Entity;

public class CaracteristiquesVehicule {

    private String marque;
    private String modele;
    private String couleur;
    private String categoriePermisRequise; // pour simplifier
    private int nbPlaces;

    public CaracteristiquesVehicule(String marque, String modele, String couleur,
                                   String categoriePermisRequise, int nbPlaces) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.categoriePermisRequise = categoriePermisRequise;
        this.nbPlaces = nbPlaces;
    }

    public String getMarque() { return marque; }
    public String getModele() { return modele; }
    public String getCouleur() { return couleur; }
    public String getCategoriePermisRequise() { return categoriePermisRequise; }
    public int getNbPlaces() { return nbPlaces; }
}

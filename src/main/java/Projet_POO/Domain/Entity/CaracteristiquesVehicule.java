package Projet_POO.Domain.Entity;


import jakarta.persistence.*;


@Entity
@Table(name = "caracteristiquesvehicule")
public class CaracteristiquesVehicule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String marque;
    private String modele;
    private String couleur;
    private String categoriePermisRequise; // pour simplifier
    private int nbPlaces;

    public CaracteristiquesVehicule(long id, String marque, String modele, String couleur,
                                   String categoriePermisRequise, int nbPlaces) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.categoriePermisRequise = categoriePermisRequise;
        this.nbPlaces = nbPlaces;
    }

    public long getIdCaracteristiquesVehicule() {return  id; }
    public String getMarque() { return marque; }
    public String getModele() { return modele; }
    public String getCouleur() { return couleur; }
    public String getCategoriePermisRequise() { return categoriePermisRequise; }
    public int getNbPlaces() { return nbPlaces; }
}

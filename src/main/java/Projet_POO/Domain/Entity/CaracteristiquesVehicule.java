package Projet_POO.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "caracteristiquesvehicule")
public class CaracteristiquesVehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marque;
    private String modele;
    private String couleur;
    private String categoriePermisRequise;
    private int nbPlaces;

    public CaracteristiquesVehicule() {
    }

    // Constructeur 
    public CaracteristiquesVehicule(String marque, String modele, String couleur,
                                    String categoriePermisRequise, int nbPlaces) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.categoriePermisRequise = categoriePermisRequise;
        this.nbPlaces = nbPlaces;
    }

    // Getter/Setter 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCategoriePermisRequise() {
        return categoriePermisRequise;
    }

    public void setCategoriePermisRequise(String categoriePermisRequise) {
        this.categoriePermisRequise = categoriePermisRequise;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }
}



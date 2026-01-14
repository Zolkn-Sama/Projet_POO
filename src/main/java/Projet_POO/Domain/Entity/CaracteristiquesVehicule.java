package Projet_POO.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // <--- INDISPENSABLE : Dit à Spring que c'est une table en BD
@Table(name = "caracteristiques_vehicule")
public class CaracteristiquesVehicule {

    @Id // <--- INDISPENSABLE : Définit la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation
    private long id;

    private String marque;
    private String modele;
    private String couleur;
    private String categoriePermisRequise;
    private int nbPlaces;

    // CONSTRUCTEUR VIDE (Obligatoire pour JPA/Hibernate)
    public CaracteristiquesVehicule() {
    }

    public CaracteristiquesVehicule(long id, String marque, String modele, String couleur,
                                    String categoriePermisRequise, int nbPlaces) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.categoriePermisRequise = categoriePermisRequise;
        this.nbPlaces = nbPlaces;
    }

    // --- Getters ---
    public long getId() { return id; }
    public String getMarque() { return marque; }
    public String getModele() { return modele; }
    public String getCouleur() { return couleur; }
    public String getCategoriePermisRequise() { return categoriePermisRequise; }
    public int getNbPlaces() { return nbPlaces; }

    // Ajoutez également les Setters si vous voulez pouvoir modifier les données
}
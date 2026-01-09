package Projet_POO.Domain.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "assurance")
public class Assurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private boolean estParDefaut;


    @Transient
    private List<ConditionAssurance> conditions;

    @Transient
    private List<CouvertureAssurance> couvertures;

    public Assurance() {
        this.conditions = new ArrayList<>();
        this.couvertures = new ArrayList<>();
    }

    public Assurance(int id, String nom, boolean estParDefaut) {
        this();
        this.id = id;
        this.nom = nom;
        this.estParDefaut = estParDefaut;
    }

    // getters / setters

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public boolean isEstParDefaut() { return estParDefaut; }

    public void setEstParDefaut(boolean estParDefaut) { this.estParDefaut = estParDefaut; }

    public List<ConditionAssurance> getConditions() {
        return new ArrayList<>(conditions);
    }

    public List<CouvertureAssurance> getCouvertures() {
        return new ArrayList<>(couvertures);
    }

    public void ajouterCondition(ConditionAssurance c) {
        if (c != null) conditions.add(c);
    }

    public void ajouterCouverture(CouvertureAssurance c) {
        if (c != null) couvertures.add(c);
    }

    /**
     * calculerPrix(typeVehicule, modele, ageLoueur) : double
     * -> formule simple pour le projet étudiant.
     */
    public double calculerPrix(TypeVehicule typeVehicule, String modele, int ageLoueur) {
        double base = 20.0;

        // surcoût selon type de véhicule
        if (typeVehicule != null) {
            String lib = typeVehicule.getLibelle().toLowerCase();
            if (lib.contains("voiture")) base += 10;
            else if (lib.contains("moto")) base += 15;
            else if (lib.contains("camion")) base += 25;
            else base += 5;
        }

        // surcoût si jeune conducteur
        if (ageLoueur < 25) {
            base *= 1.3;
        }

        // petite modif selon le modèle (léger exemple)
        if (modele != null && modele.toLowerCase().contains("sport")) {
            base *= 1.2;
        }

        return base;
    }

    @Override
    public String toString() {
        return "Assurance{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", estParDefaut=" + estParDefaut +
                '}';
    }
}

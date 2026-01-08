package Projet_POO.Domain.Entity;

import java.util.ArrayList;
import java.util.List;

public class ConditionAssurance {

    private int id;
    private int ageMin;
    private int anciennetePermisMinAnnees;
    private List<String> restrictionsGeo;

    public ConditionAssurance() {
        this.restrictionsGeo = new ArrayList<>();
    }

    public ConditionAssurance(int id, int ageMin, int anciennetePermisMinAnnees) {
        this();
        this.id = id;
        this.ageMin = ageMin;
        this.anciennetePermisMinAnnees = anciennetePermisMinAnnees;
    }

    // getters / setters

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getAgeMin() { return ageMin; }

    public void setAgeMin(int ageMin) { this.ageMin = ageMin; }

    public int getAnciennetePermisMinAnnees() { return anciennetePermisMinAnnees; }

    public void setAnciennetePermisMinAnnees(int anciennetePermisMinAnnees) {
        this.anciennetePermisMinAnnees = anciennetePermisMinAnnees;
    }

    public List<String> getRestrictionsGeo() {
        return new ArrayList<>(restrictionsGeo);
    }

    public void ajouterRestrictionGeo(String paysOuVille) {
        if (paysOuVille != null && !paysOuVille.isBlank()) {
            restrictionsGeo.add(paysOuVille);
        }
    }

    /** Vérifie si le loueur respecte les conditions. */
    public boolean estEligible(int ageLoueur, int anciennetePermisLoueur) {
        if (ageLoueur < ageMin) return false;
        if (anciennetePermisLoueur < anciennetePermisMinAnnees) return false;
        // on ignore les restrictionsGeo ici pour simplifier
        return true;
    }
}

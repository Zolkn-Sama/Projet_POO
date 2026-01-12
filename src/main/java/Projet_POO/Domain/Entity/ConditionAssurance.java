package Projet_POO.Domain.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "condition_assurance")
public class ConditionAssurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int ageMin;
    private int anciennetePermisMinAnnees;

    @ElementCollection // Pour stocker une liste simple de String en base
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

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getAgeMin() { return ageMin; }
    public void setAgeMin(int ageMin) { this.ageMin = ageMin; }
    public int getAnciennetePermisMinAnnees() { return anciennetePermisMinAnnees; }
    public void setAnciennetePermisMinAnnees(int ann) { this.anciennetePermisMinAnnees = ann; }
    public List<String> getRestrictionsGeo() { return new ArrayList<>(restrictionsGeo); }

    public void ajouterRestrictionGeo(String paysOuVille) {
        if (paysOuVille != null && !paysOuVille.isBlank()) {
            restrictionsGeo.add(paysOuVille);
        }
    }

    public boolean estEligible(int ageLoueur, int anciennetePermisLoueur) {
        if (ageLoueur < ageMin) return false;
        if (anciennetePermisLoueur < anciennetePermisMinAnnees) return false;
        return true;
    }
}
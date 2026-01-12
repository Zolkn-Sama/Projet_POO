package Projet_POO.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "condition_assurance")
public class ConditionAssurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ageMin;
    private int anciennetePermisMinAnnees;

    @ElementCollection
    @CollectionTable(
            name = "condition_assurance_restriction",
            joinColumns = @JoinColumn(name = "condition_id")
    )
    @Column(name = "restriction_geo")
    private List<String> restrictionsGeo = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "assurance_id")
    private Assurance assurance;

    public ConditionAssurance() {}

    public ConditionAssurance(int ageMin, int anciennetePermisMinAnnees) {
        this.ageMin = ageMin;
        this.anciennetePermisMinAnnees = anciennetePermisMinAnnees;
    }

    public Long getId() { return id; }

    public int getAgeMin() { return ageMin; }
    public void setAgeMin(int ageMin) { this.ageMin = ageMin; }

    public int getAnciennetePermisMinAnnees() { return anciennetePermisMinAnnees; }
    public void setAnciennetePermisMinAnnees(int anciennetePermisMinAnnees) {
        this.anciennetePermisMinAnnees = anciennetePermisMinAnnees;
    }

    public List<String> getRestrictionsGeo() { return restrictionsGeo; }
    public void setRestrictionsGeo(List<String> restrictionsGeo) {
        this.restrictionsGeo = (restrictionsGeo == null) ? new ArrayList<>() : restrictionsGeo;
    }

    public Assurance getAssurance() { return assurance; }
    public void setAssurance(Assurance assurance) { this.assurance = assurance; }

    public boolean estEligible(int ageLoueur, int anciennetePermisLoueur) {
        if (ageLoueur < ageMin) return false;
        if (anciennetePermisLoueur < anciennetePermisMinAnnees) return false;
        return true;
    }
}

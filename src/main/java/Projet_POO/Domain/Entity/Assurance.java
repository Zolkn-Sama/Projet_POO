package Projet_POO.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "assurance")
public class Assurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private boolean estParDefaut;

    @JsonManagedReference
    @OneToMany(mappedBy = "assurance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CouvertureAssurance> couvertures = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "assurance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConditionAssurance> conditions = new ArrayList<>();

    public Assurance() {}

    public Assurance(String nom, boolean estParDefaut) {
        this.nom = nom;
        this.estParDefaut = estParDefaut;
    }

    public Long getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public boolean isEstParDefaut() { return estParDefaut; }
    public void setEstParDefaut(boolean estParDefaut) { this.estParDefaut = estParDefaut; }

    public List<CouvertureAssurance> getCouvertures() { return couvertures; }
    public List<ConditionAssurance> getConditions() { return conditions; }

    // Helpers (important pour garder la cohérence)
    public void ajouterCouverture(CouvertureAssurance c) {
        if (c == null) return;
        c.setAssurance(this);
        couvertures.add(c);
    }

    public void ajouterCondition(ConditionAssurance c) {
        if (c == null) return;
        c.setAssurance(this);
        conditions.add(c);
    }
}

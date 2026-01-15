package Projet_POO.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prix_location")
public class PrixLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Partie fixe (ex: 2€ * nbJours) ou un fixe global (au choix)
    private double prixFix;

    // Partie variable en % (ex: 10%)
    private double pourcentage;

    // Total calculé et figé
    private double montantTotal;

    public PrixLocation() {}

    public PrixLocation(double prixFix, double pourcentage) {
        this.prixFix = prixFix;
        this.pourcentage = pourcentage;
        recalculer();
    }

    public void recalculer() {
        if (prixFix < 0) prixFix = 0;
        if (pourcentage < 0) pourcentage = 0;
        this.montantTotal = prixFix + (prixFix * (pourcentage / 100.0));
    }

    public Long getId() { return id; }

    public double getPrixFix() { return prixFix; }
    public void setPrixFix(double prixFix) { this.prixFix = prixFix; }

    public double getPourcentage() { return pourcentage; }
    public void setPourcentage(double pourcentage) { this.pourcentage = pourcentage; }

    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }
}

package Projet_POO.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "service_optionnel")
public class ServiceOptionnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private double prix;

    public ServiceOptionnel() {}

    // constructeur "normal" (sans id) -> recommandé en REST / création
    public ServiceOptionnel(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // ✅ constructeur COMPAT avec tes classes ServiceNettoyage etc.
    // (id peut être null, la BDD le générera quand même)
    public ServiceOptionnel(Long id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Long getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    @Override
    public String toString() {
        return "ServiceOptionnel{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}

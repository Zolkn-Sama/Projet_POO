package Projet_POO.Domain.Entity;

import Projet_POO.Domain.Enums.NomOption;
import jakarta.persistence.*;

@Entity
@Table(name = "option_vehicule")
public class OptionVehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private NomOption nom;

    public OptionVehicule() {}

    public OptionVehicule(NomOption nom) {
        this.nom = nom;
    }

    public Long getId() { return id; }

    public NomOption getNom() { return nom; }
    public void setNom(NomOption nom) { this.nom = nom; }

    @Override
    public String toString() {
        return nom.name();
    }
}

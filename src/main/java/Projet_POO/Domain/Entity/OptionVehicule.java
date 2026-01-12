package Projet_POO.Domain.Entity;

import Projet_POO.Domain.Enums.CodeOption;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "option_vehicule")
public class OptionVehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CodeOption nom;

    public OptionVehicule() {}

    public OptionVehicule(CodeOption nom) {
        this.nom = nom;
    }

    public Long getId() { return id; }

    public CodeOption getNom() { return nom; }
    public void setNom(CodeOption nom) { this.nom = nom; }

    @Override
    public String toString() {
        return nom.name();
    }
}

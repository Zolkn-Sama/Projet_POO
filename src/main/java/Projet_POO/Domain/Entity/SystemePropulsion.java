package Projet_POO.Domain.Entity;

import Projet_POO.Domain.Enums.TypePropulsion;
import jakarta.persistence.*;

@Entity
@Table(name = "systeme_propulsion")
public class SystemePropulsion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING) // Sauvegarde le nom de l'enum (ex: "MOTEUR")
    private TypePropulsion type;

    private String energie; // "Essence", "Electrique", "JetFuel", "N/A"...

    // ✅ CONSTRUCTEUR VIDE OBLIGATOIRE POUR JPA
    public SystemePropulsion() {
    }

    public SystemePropulsion(int id, TypePropulsion type, String energie) {
        this.id = id;
        this.type = type;
        this.energie = energie;
    }

    // --- Getters et Setters ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public TypePropulsion getType() { return type; }
    public void setType(TypePropulsion type) { this.type = type; }

    public String getEnergie() { return energie; }
    public void setEnergie(String energie) { this.energie = energie; }

    public boolean estMotorise() {
        return type == TypePropulsion.MOTEUR;
    }
}
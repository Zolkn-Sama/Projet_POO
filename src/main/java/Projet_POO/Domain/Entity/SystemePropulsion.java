package Projet_POO.Domain.Entity;

import Projet_POO.Domain.Enums.TypePropulsion;
import jakarta.persistence.*;

@Entity
@Table(name = "systeme_propulsion")
public class SystemePropulsion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypePropulsion type;

    private String energie;

    public SystemePropulsion() {} // Requis par JPA

    public SystemePropulsion(TypePropulsion type, String energie) {
=======
    private int id;

    @Enumerated(EnumType.STRING) // Sauvegarde le nom de l'enum (ex: "MOTEUR")
    private TypePropulsion type;

    private String energie; // "Essence", "Electrique", "JetFuel", "N/A"...

    // ✅ CONSTRUCTEUR VIDE OBLIGATOIRE POUR JPA
    public SystemePropulsion() {
    }

    public SystemePropulsion(int id, TypePropulsion type, String energie) {
        this.id = id;
>>>>>>> ALEX
        this.type = type;
        this.energie = energie;
    }

<<<<<<< HEAD
    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TypePropulsion getType() { return type; }
    public void setType(TypePropulsion type) { this.type = type; }
=======
    // --- Getters et Setters ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public TypePropulsion getType() { return type; }
    public void setType(TypePropulsion type) { this.type = type; }

>>>>>>> ALEX
    public String getEnergie() { return energie; }
    public void setEnergie(String energie) { this.energie = energie; }

    public boolean estMotorise() {
        return type == TypePropulsion.MOTEUR;
    }
}
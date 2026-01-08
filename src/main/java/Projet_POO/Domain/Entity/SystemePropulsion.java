package Projet_POO.Domain.Entity;

import Projet_POO.Domain.Enums.TypePropulsion;

public class SystemePropulsion {

    private int id;
    private TypePropulsion type;
    private String energie; // "Essence", "Electrique", "JetFuel", "N/A"...

    public SystemePropulsion(int id, TypePropulsion type, String energie) {
        this.id = id;
        this.type = type;
        this.energie = energie;
    }

    public int getId() { return id; }
    public TypePropulsion getType() { return type; }
    public String getEnergie() { return energie; }

    public boolean estMotorise() {
        return type == TypePropulsion.MOTEUR;
    }
}

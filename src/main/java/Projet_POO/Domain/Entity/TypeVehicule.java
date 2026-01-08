package Projet_POO.Domain.Entity;

public class TypeVehicule {

    private int id;
    private String libelle; // ex : Voiture, Bateau, Avion...
    private String domaine; // DomaineDeplacement en simple String ici

    public TypeVehicule(int id, String libelle, String domaine) {
        this.id = id;
        this.libelle = libelle;
        this.domaine = domaine;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDomaine() {
        return domaine;
    }
}

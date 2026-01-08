package Projet_POO.Domain.Entity;

public class CouvertureAssurance {

    private int id;
    private String libelle;
    private double plafond;   // Money simplifié en double
    private double franchise; // idem

    public CouvertureAssurance() { }

    public CouvertureAssurance(int id, String libelle, double plafond, double franchise) {
        this.id = id;
        this.libelle = libelle;
        this.plafond = plafond;
        this.franchise = franchise;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getLibelle() { return libelle; }

    public void setLibelle(String libelle) { this.libelle = libelle; }

    public double getPlafond() { return plafond; }

    public void setPlafond(double plafond) { this.plafond = plafond; }

    public double getFranchise() { return franchise; }

    public void setFranchise(double franchise) { this.franchise = franchise; }

    @Override
    public String toString() {
        return "CouvertureAssurance{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", plafond=" + plafond +
                ", franchise=" + franchise +
                '}';
    }
}

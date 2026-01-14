package Projet_POO.Domain.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Localisation {

    private String rue;
    private String ville;
    private String codePostal;
    private String pays;

    public Localisation() { }

    public Localisation(String rue, String ville, String codePostal, String pays) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.pays = pays;
    }

    public String getRue() { return rue; }

    public void setRue(String rue) { this.rue = rue; }

    public String getVille() { return ville; }

    public void setVille(String ville) { this.ville = ville; }

    public String getCodePostal() { return codePostal; }

    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }

    public String getPays() { return pays; }

    public void setPays(String pays) { this.pays = pays; }

    public void setAdresse(String adresse) {
        this.rue = adresse; // On considère que l'adresse saisie va dans le champ 'rue'
    }



    @Override
    public String toString() {
        return rue + ", " + codePostal + " " + ville + " (" + pays + ")";
    }
}

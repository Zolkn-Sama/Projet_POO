package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import Projet_POO.Domain.Enums.CodeOption;
import Projet_POO.Domain.Enums.DomaineDeplacement;
import Projet_POO.Domain.Enums.TypePropulsion;

public class FiltreRecherche {

    private String ville;
    private TypeVehicule typeVehicule;
    private DomaineDeplacement domaine;
    private TypePropulsion propulsion;
    private String marque;
    private String modele;
    private String couleur;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private double noteMin;
    private Set<CodeOption> optionsRequises;

    public FiltreRecherche() {
        this.optionsRequises = new HashSet<>();
    }

    // getters / setters

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public TypeVehicule getTypeVehicule() { return typeVehicule; }
    public void setTypeVehicule(TypeVehicule typeVehicule) { this.typeVehicule = typeVehicule; }

    public DomaineDeplacement getDomaine() { return domaine; }
    public void setDomaine(DomaineDeplacement domaine) { this.domaine = domaine; }

    public TypePropulsion getPropulsion() { return propulsion; }
    public void setPropulsion(TypePropulsion propulsion) { this.propulsion = propulsion; }

    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }

    public String getModele() { return modele; }
    public void setModele(String modele) { this.modele = modele; }

    public String getCouleur() { return couleur; }
    public void setCouleur(String couleur) { this.couleur = couleur; }

    public LocalDateTime getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDateTime dateDebut) { this.dateDebut = dateDebut; }

    public LocalDateTime getDateFin() { return dateFin; }
    public void setDateFin(LocalDateTime dateFin) { this.dateFin = dateFin; }

    public double getNoteMin() { return noteMin; }
    public void setNoteMin(double noteMin) { this.noteMin = noteMin; }

    public Set<CodeOption> getOptionsRequises() { return optionsRequises; }
    public void ajouterOptionRequise(CodeOption code) {
        if (code != null) optionsRequises.add(code);
    }
}

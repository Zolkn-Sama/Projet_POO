package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String immatriculation;
    private Localisation localisationVehicule;
    private boolean deposeDifferenteAutorisee;

    // compositions / associations
    @Transient
    private TypeVehicule typeVehicule;

    @Transient
    private SystemePropulsion systemePropulsion;

    @Transient
    private CaracteristiquesVehicule caracteristiques;

    @Transient
    private List<OptionVehicule> options = new ArrayList<>();

    @Transient
    private List<Disponibilite> disponibilites = new ArrayList<>();

    @Transient
    private List<Note> notes = new ArrayList<>();

    @Transient
    private List<ContratLocation> contrats = new ArrayList<>();

    public Vehicule() {
    }

    public Vehicule(String immatriculation, Localisation localisationVehicule, boolean deposeDifferenteAutorisee,
                    TypeVehicule typeVehicule) {
        this.immatriculation = immatriculation;
        this.localisationVehicule = localisationVehicule;
        this.deposeDifferenteAutorisee = deposeDifferenteAutorisee;
        this.typeVehicule = typeVehicule;
    }

    // --- Getters / Setters ---
    public Long getId() {
        return id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Localisation getLocalisationVehicule() {
        return localisationVehicule;
    }

    public void setLocalisationVehicule(Localisation localisationVehicule) {
        this.localisationVehicule = localisationVehicule;
    }

    public boolean isDeposeDifferenteAutorisee() {
        return deposeDifferenteAutorisee;
    }

    public void setDeposeDifferenteAutorisee(boolean deposeDifferenteAutorisee) {
        this.deposeDifferenteAutorisee = deposeDifferenteAutorisee;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public CaracteristiquesVehicule getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(CaracteristiquesVehicule caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public List<Disponibilite> getDisponibilites() {
        return new ArrayList<>(disponibilites);
    }

    public void setDisponibilites(List<Disponibilite> disponibilites) {
        this.disponibilites = disponibilites;
    }

    public List<OptionVehicule> getOptions() {
        return new ArrayList<>(options);
    }

    public void setOptions(List<OptionVehicule> options) {
        this.options = options;
    }

    public List<ContratLocation> getContrats() {
        return new ArrayList<>(contrats);
    }

    public void setContrats(List<ContratLocation> contratLocations) {
        this.contrats = contratLocations;
    }

    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    // --- Méthodes métier attendues par ton Service/Catalogue/Loueur ---

    public double getNoteMoyenne() {
        if (notes.isEmpty())
            return 0.0;
        double somme = 0.0;
        for (Note n : notes) {
            somme += n.noteGlobale(); // il faut que Note ait noteGlobale()
        }
        return somme / notes.size();
    }

    public boolean estDisponible(LocalDateTime debut, LocalDateTime fin) {
        if (debut == null || fin == null || !debut.isBefore(fin))
            return false;

        // dispo si au moins une période couvre totalement [debut, fin]
        for (Disponibilite p : disponibilites) {
            if (p != null && p.getDebut() != null && p.getFin() != null) {
                boolean couvre = !debut.isBefore(p.getDebut()) && !fin.isAfter(p.getFin());
                if (couvre)
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", immatriculation='" + immatriculation + '\'' +
                ", localisationVehicule='" + localisationVehicule + '\'' +
                ", deposeDifferenteAutorisee=" + deposeDifferenteAutorisee +
                ", typeVehicule='" + typeVehicule + '\'' +
                '}';
    }

}
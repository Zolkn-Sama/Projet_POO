package Projet_POO.Domain.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="vehicule")

public class Vehicule {

    // ---- attributs du diagramme ----
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    
    private String immatriculation;              // UML : UUID -> ici String (plus simple pour une plaque)
    private String villeDisponibilite;
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
    private List<PeriodeDisponibilite> periodesDisponibilite = new ArrayList<>();

    @Transient
    private List<Note> notes = new ArrayList<>();

    @Transient
    private List<ContratLocation> contrats = new ArrayList<>();


    // ---- constructeurs ----

    public Vehicule() {
        this.options = new ArrayList<>();
        this.periodesDisponibilite = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.contrats = new ArrayList<>();

    }

    public Vehicule(String immatriculation,
                    String villeDisponibilite,
                    boolean deposeDifferenteAutorisee,
                    TypeVehicule typeVehicule,
                    SystemePropulsion systemePropulsion,
                    CaracteristiquesVehicule caracteristiques) {

        this();
        this.immatriculation = immatriculation;
        this.villeDisponibilite = villeDisponibilite;
        this.deposeDifferenteAutorisee = deposeDifferenteAutorisee;
        this.typeVehicule = typeVehicule;
        this.systemePropulsion = systemePropulsion;
        this.caracteristiques = caracteristiques;
    }

    // ---- getters / setters ----

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getVilleDisponibilite() {
        return villeDisponibilite;
    }

    public void setVilleDisponibilite(String villeDisponibilite) {
        this.villeDisponibilite = villeDisponibilite;
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

    public SystemePropulsion getSystemePropulsion() {
        return systemePropulsion;
    }

    public void setSystemePropulsion(SystemePropulsion systemePropulsion) {
        this.systemePropulsion = systemePropulsion;
    }

    public CaracteristiquesVehicule getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(CaracteristiquesVehicule caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public List<OptionVehicule> getOptions() {
        return new ArrayList<>(options);
    }

    public List<PeriodeDisponibilite> getPeriodesDisponibilite() {
        return new ArrayList<>(periodesDisponibilite);
    }

    public Long getId() {
    return id;
}


    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    // ---- méthodes de gestion des listes ----
    
    public void ajouterContrat(ContratLocation contrat) {
        if (contrat != null && !contrats.contains(contrat)) {
            contrats.add(contrat);
        }
    }

    public List<ContratLocation> getContrats() {
        return new ArrayList<>(contrats);
    }

    public void ajouterOption(OptionVehicule option) {
        if (option != null && !options.contains(option)) {
            options.add(option);
        }
    }

    public void ajouterPeriodeDisponibilite(PeriodeDisponibilite periode) {
        if (periode != null) {
            periodesDisponibilite.add(periode);
        }
    }

    /** méthode demandée : ajouterNote(Note) */
    public void ajouterNote(Note note) {
        if (note != null) {
            notes.add(note);
        }
    }

    // ---- méthodes UML : noteMoyenne, estDisponible ----

    /** noteMoyenne(): double */
    public double noteMoyenne() {
        if (notes.isEmpty()) {
            return 0.0;
        }
        double somme = 0.0;
        for (Note n : notes) {
            somme += n.noteGlobale();   // on suppose que Note a bien noteGlobale()
        }
        return somme / notes.size();
    }

    public boolean estDisponible(LocalDateTime debut, LocalDateTime fin) {
        if (debut == null || fin == null || !debut.isBefore(fin)) {
            return false;
        }

        for (PeriodeDisponibilite p : periodesDisponibilite) {
            if (!debut.isBefore(p.getDebut()) && !fin.isAfter(p.getFin())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "immatriculation='" + immatriculation + '\'' +
                ", villeDisponibilite='" + villeDisponibilite + '\'' +
                ", type=" + (typeVehicule != null ? typeVehicule.getLibelle() : "N/A") +
                '}';
    }
}



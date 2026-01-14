package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String immatriculation;
    private Localisation localisationVehicule;
    private boolean deposeDifferenteAutorisee;
    private Long agentId;


    // compositions / associations
    @ManyToOne
    @JoinColumn(name = "type_vehicule_id")
    private TypeVehicule typeVehicule;

    @Transient
    private SystemePropulsion systemePropulsion;

    @ManyToOne
    @JoinColumn(name = "caracteristiques_id")
    private CaracteristiquesVehicule caracteristiques;

    @ManyToMany
    @JoinTable(
            name = "vehicule_options",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private List<OptionVehicule> options = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "vehicule_disponibilites", joinColumns = @JoinColumn(name = "vehicule_id"))
    private List<Disponibilite> disponibilites = new ArrayList<>();

    // Ajoutez ce champ pour que findByVilleDisponibilite fonctionne
    private String villeDisponibilite;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<NoteVehicule> notes = new ArrayList<>(); // Utilise NoteVehicule au lieu de Note

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
    public Long getAgentId() { return agentId; }
    public void setAgentId(Long agentId) { this.agentId = agentId; }

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

    public List<NoteVehicule> getNotes() {
        return new ArrayList<>(notes);
    }
    public void setNotes(List<NoteVehicule> notes) {
        this.notes = notes;
    }
    // --- Méthodes métier attendues par ton Service/Catalogue/Loueur ---

    public double getNoteMoyenne() {
        if (notes == null || notes.isEmpty()) return 0.0;
        double somme = 0.0;
        for (NoteVehicule n : notes) { // Utilise NoteVehicule ici
            somme += n.noteGlobale();
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
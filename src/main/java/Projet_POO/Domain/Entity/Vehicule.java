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
    private String villeDisponibilite;
    private boolean deposeDifferenteAutorisee;

    @ManyToMany
    @JoinTable(
            name = "vehicule_option",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private Set<OptionVehicule> options = new HashSet<>();


    // compositions / associations
    @Transient
    private TypeVehicule typeVehicule;

    @Transient
    private SystemePropulsion systemePropulsion;

    @Transient
    private CaracteristiquesVehicule caracteristiques;


    @Transient
    private List<Disponibilite> disponibilites = new ArrayList<>();

    @Transient
    private List<Note> notes = new ArrayList<>();

    @Transient
    private List<ContratLocation> contrats = new ArrayList<>();


    public Vehicule() {
    }

    public Vehicule(String immatriculation, String villeDisponibilite, boolean deposeDifferenteAutorisee, TypeVehicule typeVehicule) {
        this.immatriculation = immatriculation;
        this.villeDisponibilite = villeDisponibilite;
        this.deposeDifferenteAutorisee = deposeDifferenteAutorisee;
        this.typeVehicule = typeVehicule;
    }



    // --- Getters / Setters ---
    public Long getId() { return id; }

    public String getImmatriculation() { return immatriculation; }
    public void setImmatriculation(String immatriculation) { this.immatriculation = immatriculation; }

    public String getVilleDisponibilite() { return villeDisponibilite; }
    public void setVilleDisponibilite(String villeDisponibilite) { this.villeDisponibilite = villeDisponibilite; }

    public boolean isDeposeDifferenteAutorisee() { return deposeDifferenteAutorisee; }
    public void setDeposeDifferenteAutorisee(boolean deposeDifferenteAutorisee) {
        this.deposeDifferenteAutorisee = deposeDifferenteAutorisee;
    }

    public TypeVehicule getTypeVehicule() { return typeVehicule; }
    public void setTypeVehicule(TypeVehicule typeVehicule) { this.typeVehicule = typeVehicule; }

    public List<Disponibilite> getDisponibilites() {
        return new ArrayList<>(disponibilites);
    }

    public Set<OptionVehicule> getOptions() {
        return options;
    }

    public List<ContratLocation> getContrats() {
        return new ArrayList<>(contrats);
    }

    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    // --- Méthodes métier attendues par ton Service/Catalogue/Loueur ---

    public void ajouterOption(OptionVehicule option) {
        if (option != null) {
            options.add(option);
        }
    }

    public void ajouterDisponibilite(Disponibilite periode) {
        if (periode != null) disponibilites.add(periode);
    }

    public void ajouterNote(Note note) {
        if (note != null) notes.add(note);
    }

    public void ajouterContrat(ContratLocation contrat) {
        if (contrat != null && !contrats.contains(contrat)) contrats.add(contrat);
    }

    public double getNoteMoyenne() {
        if (notes.isEmpty()) return 0.0;
        double somme = 0.0;
        for (Note n : notes) {
            somme += n.noteGlobale(); // il faut que Note ait noteGlobale()
        }
        return somme / notes.size();
    }

    public boolean estDisponible(LocalDateTime debut, LocalDateTime fin) {
        if (debut == null || fin == null || !debut.isBefore(fin)) return false;

        // dispo si au moins une période couvre totalement [debut, fin]
        for (Disponibilite p : disponibilites) {
            if (p != null && p.getDebut() != null && p.getFin() != null) {
                boolean couvre = !debut.isBefore(p.getDebut()) && !fin.isAfter(p.getFin());
                if (couvre) return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", immatriculation='" + immatriculation + '\'' +
                ", villeDisponibilite='" + villeDisponibilite + '\'' +
                ", deposeDifferenteAutorisee=" + deposeDifferenteAutorisee +
                ", typeVehicule='" + typeVehicule + '\'' +
                '}';
    }
}

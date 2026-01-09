package Projet_POO.Domain.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="vehicule")

@Entity
@Table(name = "vehicule")
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


    private boolean deposeDifferenteAutorisee;

    public Vehicule() {
        this.options = new ArrayList<>();
        this.periodesDisponibilite = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.contrats = new ArrayList<>();

    }

    // note globale stockée (utile pour affichage US.V.1)
    private double noteMoyenne;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="vehicule_options", joinColumns=@JoinColumn(name="vehicule_id"))
    @Enumerated(EnumType.STRING)
    @Column(name="code_option")
    private Set<CodeOption> options = new HashSet<>();

    @OneToMany(mappedBy="vehicule", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<PeriodeDisponibilite> periodesDisponibilite = new ArrayList<>();

    public Vehicule() {}

    public Vehicule(String immatriculation, String villeDisponibilite, boolean deposeDifferenteAutorisee,
                    String typeVehiculeLibelle) {
        this.immatriculation = immatriculation;
        this.villeDisponibilite = villeDisponibilite;
        this.deposeDifferenteAutorisee = deposeDifferenteAutorisee;
        this.typeVehiculeLibelle = typeVehiculeLibelle;
        this.noteMoyenne = 0.0;
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

    public void ajouterOption(CodeOption option) {
        if (option != null) options.add(option);
    }

    // getters/setters
    public Long getId() { return id; }

    public String getImmatriculation() { return immatriculation; }
    public void setImmatriculation(String immatriculation) { this.immatriculation = immatriculation; }

    public String getVilleDisponibilite() { return villeDisponibilite; }
    public void setVilleDisponibilite(String villeDisponibilite) { this.villeDisponibilite = villeDisponibilite; }

    public boolean isDeposeDifferenteAutorisee() { return deposeDifferenteAutorisee; }
    public void setDeposeDifferenteAutorisee(boolean deposeDifferenteAutorisee) { this.deposeDifferenteAutorisee = deposeDifferenteAutorisee; }

    public String getTypeVehiculeLibelle() { return typeVehiculeLibelle; }
    public void setTypeVehiculeLibelle(String typeVehiculeLibelle) { this.typeVehiculeLibelle = typeVehiculeLibelle; }

    public double getNoteMoyenne() { return noteMoyenne; }
    public void setNoteMoyenne(double noteMoyenne) { this.noteMoyenne = noteMoyenne; }

    public Set<CodeOption> getOptions() { return options; }
    public List<PeriodeDisponibilite> getPeriodesDisponibilite() { return periodesDisponibilite; }
}



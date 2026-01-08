package Projet_POO.Domain.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import Projet_POO.Domain.Enums.CodeOption;

@Entity
@Table(name = "vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String immatriculation;

    @Column(nullable=false)
    private String villeDisponibilite;

    private boolean deposeDifferenteAutorisee;

    // Pour rester simple au début : on met typeVehicule en String OU on fera entity après.
    private String typeVehiculeLibelle;

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

    // helpers
    public void ajouterPeriodeDisponibilite(PeriodeDisponibilite periode) {
        if (periode == null) return;
        periode.setVehicule(this);
        periodesDisponibilite.add(periode);
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

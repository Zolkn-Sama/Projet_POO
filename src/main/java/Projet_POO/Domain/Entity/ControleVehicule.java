package Projet_POO.Domain.Entity;

import Projet_POO.Domain.Enums.TypeEntretien;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Map;

@Entity
public class ControleVehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @OneToOne indique qu'un véhicule possède une seule fiche de contrôle technique active
    @OneToOne
    @JoinColumn(name = "vehicule_id", unique = true)
    private Vehicule vehicule;

    private LocalDate dateCT;
    private Integer kilometrageActuel;

    @ElementCollection
    @CollectionTable(name = "historique_entretien_km")
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "km_au_dernier_changement")
    private Map<TypeEntretien, Integer> kmDernierEntretien;

    public ControleVehicule() {}

    // Getters / Setters
    public Vehicule getVehicule() { return vehicule; }
    public void setVehicule(Vehicule vehicule) { this.vehicule = vehicule; }

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    public LocalDate getDateCT() { return dateCT; }
    public Integer getKilometrageActuel() { return kilometrageActuel; }
    public Map<TypeEntretien, Integer> getKmDernierEntretien() { return kmDernierEntretien; }
}

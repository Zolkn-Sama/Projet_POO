package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Projet_POO.Domain.Enums.StatutContrat;

@Entity
public class ContratLocation {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String lieuPrise;
    private String lieuDepose;
    private StatutContrat statut;
    private double montantTotal;

    // 🔴 NOUVEAU :
    private Loueur loueur;
    private Vehicule vehicule;
    private Assurance assurance;
    private List<ServiceOptionnel> services;

    public ContratLocation() {
        this.services = new ArrayList<>();
    }

    public ContratLocation(int id,
                           LocalDateTime dateDebut,
                           LocalDateTime dateFin,
                           String lieuPrise,
                           String lieuDepose,
                           StatutContrat statut,
                           double montantTotal,
                           Loueur loueur,
                           Vehicule vehicule,
                           Assurance assurance) {

        this();
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieuPrise = lieuPrise;
        this.lieuDepose = lieuDepose;
        this.statut = statut;
        this.montantTotal = montantTotal;
        this.loueur = loueur;
        this.vehicule = vehicule;
        this.assurance = assurance;
    }

    // ---------- getters / setters classiques ----------

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDateTime getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDateTime dateDebut) { this.dateDebut = dateDebut; }

    public LocalDateTime getDateFin() { return dateFin; }
    public void setDateFin(LocalDateTime dateFin) { this.dateFin = dateFin; }

    public String getLieuPrise() { return lieuPrise; }
    public void setLieuPrise(String lieuPrise) { this.lieuPrise = lieuPrise; }

    public String getLieuDepose() { return lieuDepose; }
    public void setLieuDepose(String lieuDepose) { this.lieuDepose = lieuDepose; }

    public StatutContrat getStatut() { return statut; }
    public void setStatut(StatutContrat statut) { this.statut = statut; }

    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }

    public Loueur getLoueur() { return loueur; }
    public void setLoueur(Loueur loueur) { this.loueur = loueur; }

    public Vehicule getVehicule() { return vehicule; }
    public void setVehicule(Vehicule vehicule) { this.vehicule = vehicule; }

    public Assurance getAssurance() { return assurance; }
    public void setAssurance(Assurance assurance) { this.assurance = assurance; }

    public List<ServiceOptionnel> getServices() {
        return new ArrayList<>(services);
    }

    public void ajouterService(ServiceOptionnel service) {
        if (service != null) {
            services.add(service);
        }
    }

    // ---------- méthode métier ----------

    public double montantTotal() {
        return montantTotal;
    }

    @Override
    public String toString() {
        return "ContratLocation{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", lieuPrise='" + lieuPrise + '\'' +
                ", lieuDepose='" + lieuDepose + '\'' +
                ", statut=" + statut +
                ", montantTotal=" + montantTotal +
                '}';
    }
}


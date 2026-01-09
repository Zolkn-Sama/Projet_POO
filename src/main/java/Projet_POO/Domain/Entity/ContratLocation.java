package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;

import Projet_POO.Domain.Enums.StatutContrat;
import jakarta.persistence.*;

@Entity
@Table(name = "contrat_location")
public class ContratLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    private String lieuPrise;
    private String lieuDepose;

    @Enumerated(EnumType.STRING)
    private StatutContrat statut;

    private double montantTotal;

    // --- version simple: on stocke des IDs ---
    private Long loueurId;
    private Long vehiculeId;
    private Long assuranceId;

    public ContratLocation() { }

    public ContratLocation(LocalDateTime dateDebut, LocalDateTime dateFin,
                           String lieuPrise, String lieuDepose,
                           StatutContrat statut, double montantTotal,
                           Long loueurId, Long vehiculeId, Long assuranceId) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieuPrise = lieuPrise;
        this.lieuDepose = lieuDepose;
        this.statut = statut;
        this.montantTotal = montantTotal;
        this.loueurId = loueurId;
        this.vehiculeId = vehiculeId;
        this.assuranceId = assuranceId;
    }

    public Long getId() { return id; }

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

    public Long getLoueurId() { return loueurId; }
    public void setLoueurId(Long loueurId) { this.loueurId = loueurId; }

    public Long getVehiculeId() { return vehiculeId; }
    public void setVehiculeId(Long vehiculeId) { this.vehiculeId = vehiculeId; }

    public Long getAssuranceId() { return assuranceId; }
    public void setAssuranceId(Long assuranceId) { this.assuranceId = assuranceId; }

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
                ", loueurId=" + loueurId +
                ", vehiculeId=" + vehiculeId +
                ", assuranceId=" + assuranceId +
                '}';
    }
}

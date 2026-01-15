package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;

import Projet_POO.Domain.Enums.StatutContrat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // total final du contrat (figé)
    private double montantTotal;

    // ✅ Trace paiement via solde
    private double montantPayeParSolde;
    private double montantAPayer;

    // --- version simple: IDs ---
    private Long loueurId;
    private Long vehiculeId;
    private Long assuranceId;

    // ✅ PrixLocation attaché au contrat
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "prix_location_id")
    private PrixLocation prixLocation;

    public ContratLocation() {}

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

    public double getMontantPayeParSolde() { return montantPayeParSolde; }
    public void setMontantPayeParSolde(double montantPayeParSolde) { this.montantPayeParSolde = montantPayeParSolde; }

    public double getMontantAPayer() { return montantAPayer; }
    public void setMontantAPayer(double montantAPayer) { this.montantAPayer = montantAPayer; }

    public Long getLoueurId() { return loueurId; }
    public void setLoueurId(Long loueurId) { this.loueurId = loueurId; }

    public Long getVehiculeId() { return vehiculeId; }
    public void setVehiculeId(Long vehiculeId) { this.vehiculeId = vehiculeId; }

    public Long getAssuranceId() { return assuranceId; }
    public void setAssuranceId(Long assuranceId) { this.assuranceId = assuranceId; }

    public PrixLocation getPrixLocation() { return prixLocation; }
    public void setPrixLocation(PrixLocation prixLocation) { this.prixLocation = prixLocation; }
}

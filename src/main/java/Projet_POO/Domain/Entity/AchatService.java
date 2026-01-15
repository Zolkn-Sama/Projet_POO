package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;

import Projet_POO.Domain.Enums.StatutAchatService;
import jakarta.persistence.*;

@Entity
@Table(
        name = "achat_service",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_agent_service", columnNames = {"agent_id", "service_id"})
        }
)
public class AchatService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="agent_id", nullable = false)
    private Long agentId;

    @Column(name="service_id", nullable = false)
    private Long serviceId;

    private LocalDateTime dateAchat;

    private double montantTotal;
    private double montantPayeParSolde;
    private double montantRestant;

    @Enumerated(EnumType.STRING)
    private StatutAchatService statut;

    public AchatService() {}

    public AchatService(Long agentId, Long serviceId, LocalDateTime dateAchat,
                        double montantTotal, double montantPayeParSolde, double montantRestant,
                        StatutAchatService statut) {
        this.agentId = agentId;
        this.serviceId = serviceId;
        this.dateAchat = dateAchat;
        this.montantTotal = montantTotal;
        this.montantPayeParSolde = montantPayeParSolde;
        this.montantRestant = montantRestant;
        this.statut = statut;
    }

    public Long getId() { return id; }

    public Long getAgentId() { return agentId; }
    public void setAgentId(Long agentId) { this.agentId = agentId; }

    public Long getServiceId() { return serviceId; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }

    public LocalDateTime getDateAchat() { return dateAchat; }
    public void setDateAchat(LocalDateTime dateAchat) { this.dateAchat = dateAchat; }

    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }

    public double getMontantPayeParSolde() { return montantPayeParSolde; }
    public void setMontantPayeParSolde(double montantPayeParSolde) { this.montantPayeParSolde = montantPayeParSolde; }

    public double getMontantRestant() { return montantRestant; }
    public void setMontantRestant(double montantRestant) { this.montantRestant = montantRestant; }

    public StatutAchatService getStatut() { return statut; }
    public void setStatut(StatutAchatService statut) { this.statut = statut; }
}

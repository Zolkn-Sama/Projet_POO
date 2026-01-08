package Projet_POO.Domain.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="periode_disponibilite")
public class PeriodeDisponibilite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime debut;
    private LocalDateTime fin;

    @ManyToOne
    @JoinColumn(name="vehicule_id", nullable=false)
    private Vehicule vehicule;

    public PeriodeDisponibilite() {}

    public PeriodeDisponibilite(LocalDateTime debut, LocalDateTime fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public Long getId() { return id; }

    public LocalDateTime getDebut() { return debut; }
    public void setDebut(LocalDateTime debut) { this.debut = debut; }

    public LocalDateTime getFin() { return fin; }
    public void setFin(LocalDateTime fin) { this.fin = fin; }

    public Vehicule getVehicule() { return vehicule; }
    public void setVehicule(Vehicule vehicule) { this.vehicule = vehicule; }
}

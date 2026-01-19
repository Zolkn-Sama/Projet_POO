package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;

@Embeddable
public class Disponibilite {
    
    private LocalDateTime debut;
    private LocalDateTime fin;

    // constructeur
    public Disponibilite() {
    }

    public Disponibilite(LocalDateTime debut, LocalDateTime fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }
}


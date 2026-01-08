package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;

public class PeriodeDisponibilite {

    private LocalDateTime debut;
    private LocalDateTime fin;

    public PeriodeDisponibilite(LocalDateTime debut, LocalDateTime fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public LocalDateTime getDebut() { return debut; }
    public LocalDateTime getFin() { return fin; }
}

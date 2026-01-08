package Projet_POO.Domain.Entity;

import java.time.LocalDateTime;

@Entity
public class PeriodeDisponibilite {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime debut;
    private LocalDateTime fin;

    public PeriodeDisponibilite(LocalDateTime debut, LocalDateTime fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public LocalDateTime getDebut() { return debut; }
    public LocalDateTime getFin() { return fin; }
}


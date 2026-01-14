package Projet_POO.Domain.Entity;

import Projet_POO.Domain.Enums.StatutParrainage;
import jakarta.persistence.*;

@Entity
@Table(name = "parrainage")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Parrainage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    private double montantRecompense;

    private boolean recompenseVersee = false;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private StatutParrainage statut = StatutParrainage.EN_ATTENTE;

    public Long getId() { return id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public double getMontantRecompense() { return montantRecompense; }
    public void setMontantRecompense(double montantRecompense) { this.montantRecompense = montantRecompense; }

    public boolean isRecompenseVersee() { return recompenseVersee; }
    public void setRecompenseVersee(boolean recompenseVersee) { this.recompenseVersee = recompenseVersee; }

    public StatutParrainage getStatut() { return statut; }
    public void setStatut(StatutParrainage statut) { this.statut = statut; }
}

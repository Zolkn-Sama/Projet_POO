package Projet_POO.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parrainage_loueur")
public class ParrainageLoueur extends Parrainage {

    @ManyToOne(optional = false)
    @JoinColumn(name = "parrain_id")
    private Loueur parrain;

    @ManyToOne
    @JoinColumn(name = "filleul_id")
    private Loueur filleul;

    public Loueur getParrain() { return parrain; }
    public void setParrain(Loueur parrain) { this.parrain = parrain; }

    public Loueur getFilleul() { return filleul; }
    public void setFilleul(Loueur filleul) { this.filleul = filleul; }
}

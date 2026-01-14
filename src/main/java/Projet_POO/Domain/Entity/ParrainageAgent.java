package Projet_POO.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parrainage_agent")
public class ParrainageAgent extends Parrainage {

    @ManyToOne(optional = false)
    @JoinColumn(name = "parrain_id")
    private Agent parrain;

    @ManyToOne
    @JoinColumn(name = "filleul_id")
    private Agent filleul;

    public Agent getParrain() { return parrain; }
    public void setParrain(Agent parrain) { this.parrain = parrain; }

    public Agent getFilleul() { return filleul; }
    public void setFilleul(Agent filleul) { this.filleul = filleul; }
}

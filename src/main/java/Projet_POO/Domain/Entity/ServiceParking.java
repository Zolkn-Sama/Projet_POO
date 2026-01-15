package Projet_POO.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_parking")
@PrimaryKeyJoinColumn(name = "id")
public class ServiceParking extends Service {

    private final float serviceFees = 0.02f;

    private Localisation localisationParking;
    private Double pourcentageReductionAgent;

    public ServiceParking() { super(); }

    public ServiceParking(Long id, String nom, double prix, Localisation localisationParking, Double pourcentageReductionAgent) {
        super(id, nom, prix);
        this.localisationParking = localisationParking;
        this.pourcentageReductionAgent = pourcentageReductionAgent;
    }

    public Localisation getLocalisation() { return localisationParking; }
    public void setLocalisation(Localisation localisationParking) { this.localisationParking = localisationParking; }

    public Double getPourcentageReductionAgent() { return pourcentageReductionAgent; }
    public void setPourcentageReductionAgent(Double pourcentageReductionAgent) { this.pourcentageReductionAgent = pourcentageReductionAgent; }

        @Override
    protected Double CalculerPrix(Vehicule v) {
        return v.getPrixJournalier() * serviceFees;
    }

}


package Projet_POO.Domain.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_depot")
@PrimaryKeyJoinColumn(name = "id")
public class ServiceDepotVehicule extends ServiceOptionnel {

    private String localisation;
    private String horaires;

    public ServiceDepotVehicule() { super(); }

    public ServiceDepotVehicule(String nom, double prix, String localisation, String horaires) {
        super(nom, prix);
        this.localisation = localisation;
        this.horaires = horaires;
    }

    public String getLocalisation() { return localisation; }
    public void setLocalisation(String localisation) { this.localisation = localisation; }

    public String getHoraires() { return horaires; }
    public void setHoraires(String horaires) { this.horaires = horaires; }
}


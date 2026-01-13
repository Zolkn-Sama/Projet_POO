package Projet_POO.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_depot")
@PrimaryKeyJoinColumn(name = "id")
public class ServiceDepotVehicule extends Service {

    private String localisation;
    private String horaires;

    public ServiceDepotVehicule() { super(); }

    public ServiceDepotVehicule(Long id, String nom, double prix, String localisation, String horaires) {
        super(id, nom, prix);
        this.localisation = localisation;
        this.horaires = horaires;
    }

    public String getLocalisation() { return localisation; }
    public void setLocalisation(String localisation) { this.localisation = localisation; }

    public String getHoraires() { return horaires; }
    public void setHoraires(String horaires) { this.horaires = horaires; }
}


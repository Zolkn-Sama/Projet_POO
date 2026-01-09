package Projet_POO.Domain.Entity;

public class ServiceDepotVehicule extends ServiceOptionnel {

    private String localisation;
    private String horaires;

    public ServiceDepotVehicule() { }

    public ServiceDepotVehicule(long id, String nom, double prix,
                                String localisation, String horaires) {
        super(id, nom, prix);
        this.localisation = localisation;
        this.horaires = horaires;
    }

    public String getLocalisation() { return localisation; }

    public void setLocalisation(String localisation) { this.localisation = localisation; }

    public String getHoraires() { return horaires; }

    public void setHoraires(String horaires) { this.horaires = horaires; }

    @Override
    public String toString() {
        return "ServiceDepotVehicule{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", prix=" + getPrix() +
                ", localisation='" + localisation + '\'' +
                ", horaires='" + horaires + '\'' +
                '}';
    }
}

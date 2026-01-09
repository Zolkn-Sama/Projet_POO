package Projet_POO.Domain.Entity;

public class ServiceNettoyage extends ServiceOptionnel {

    private String typeService; // ex : "Intérieur", "Extérieur", "Complet"

    public ServiceNettoyage() { }

    public ServiceNettoyage(long id, String nom, double prix, String typeService) {
        super(id, nom, prix);
        this.typeService = typeService;
    }

    public String getTypeService() { return typeService; }

    public void setTypeService(String typeService) { this.typeService = typeService; }

    @Override
    public String toString() {
        return "ServiceNettoyage{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", prix=" + getPrix() +
                ", typeService='" + typeService + '\'' +
                '}';
    }
}

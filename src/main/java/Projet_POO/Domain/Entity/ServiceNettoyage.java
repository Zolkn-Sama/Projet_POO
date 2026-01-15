package Projet_POO.Domain.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_nettoyage")
@PrimaryKeyJoinColumn(name = "id")
public class ServiceNettoyage extends Service {

    private final float serviceFees = 0.02f;

    @Column(name = "type_service")
    private String typeService;

    public ServiceNettoyage() { super(); }

    public ServiceNettoyage(Long id, String nom, double prix, String typeService) {
        super(id, nom, prix);
        this.typeService = typeService;
    }

    public String getTypeService() { return typeService; }
    public void setTypeService(String typeService) { this.typeService = typeService; }

    @Override
    protected Double CalculerPrix(Vehicule v) {
        return v.getPrixJournalier() * serviceFees;
    }
}

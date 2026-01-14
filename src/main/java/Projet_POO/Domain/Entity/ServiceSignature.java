package Projet_POO.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_parking")
@PrimaryKeyJoinColumn(name = "id")
public class ServiceSignature extends Service {

    private String signatureElectronique;

    public ServiceSignature() { super(); }

    public ServiceSignature(Long id, String nom, double prix, String signatureElectronique) {
        super(id, nom, prix);
        this.signatureElectronique = signatureElectronique;
    }

    public String getSignature() { return signatureElectronique; }
    public void setSignature(String signatureElectronique) { this.signatureElectronique = signatureElectronique; }

}


package Projet_POO.Domain.Entity;

import java.util.ArrayList;
import java.util.List;

public class HistoriqueVehicule {

    private Vehicule vehicule;
    private List<ContratLocation> contrats;

    public HistoriqueVehicule(Vehicule vehicule, List<ContratLocation> contrats) {
        this.vehicule = vehicule;
        this.contrats = new ArrayList<>(contrats);
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public List<ContratLocation> getContrats() {
        return new ArrayList<>(contrats);
    }

    @Override
    public String toString() {
        return "HistoriqueVehicule{" +
                "vehicule=" + vehicule +
                ", nbContrats=" + contrats.size() +
                '}';
    }
}

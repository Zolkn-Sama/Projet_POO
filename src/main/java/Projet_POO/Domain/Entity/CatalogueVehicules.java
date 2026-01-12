package Projet_POO.Domain.Entity;

import Projet_POO.Domain.Enums.CodeOption;

import java.util.ArrayList;
import java.util.List;

public class CatalogueVehicules {

    private List<Vehicule> vehicules;

    public CatalogueVehicules() {
        this.vehicules = new ArrayList<>();
    }

    public void ajouterVehicule(Vehicule v) {
        if (v != null && !vehicules.contains(v)) {
            vehicules.add(v);
        }
    }

    public List<Vehicule> getVehicules() {
        return new ArrayList<>(vehicules);
    }

    /**
     * Filtre les véhicules disponibles selon le FiltreRecherche.
     * Implémentation simple, tu pourras l’enrichir.
     */
    public List<Vehicule> listerDisponibles(FiltreRecherche f) {
        List<Vehicule> resultat = new ArrayList<>();

        for (Vehicule v : vehicules) {

            // ville
            if (f.getVille() != null &&
                !f.getVille().equalsIgnoreCase(v.getVilleDisponibilite())) {
                continue;
            }

            // type véhicule
            if (f.getTypeVehicule() != null &&
                v.getTypeVehicule() != f.getTypeVehicule()) {
                continue;
            }

            // note minimale
            if (f.getNoteMin() > 0 &&
                v.getNoteMoyenne() < f.getNoteMin()) {
                continue;
            }

            // options requises
            if (!f.getOptionsRequises().isEmpty()) {
                if (!vehiculePossedeOptions(v, f.getOptionsRequises())) {
                    continue;
                }
            }

            // date de disponibilité
            if (f.getDateDebut() != null && f.getDateFin() != null) {
                if (!v.estDisponible(f.getDateDebut(), f.getDateFin())) {
                    continue;
                }
            }

            resultat.add(v);
        }

        return resultat;
    }

    private boolean vehiculePossedeOptions(Vehicule v, java.util.Set<CodeOption> optionsRequises) {
        java.util.Set<CodeOption> codesVehicule = new java.util.HashSet<>();
        for (OptionVehicule opt : v.getOptions()) {
            codesVehicule.add(opt.getCode());
        }
        return codesVehicule.containsAll(optionsRequises);
    }
}

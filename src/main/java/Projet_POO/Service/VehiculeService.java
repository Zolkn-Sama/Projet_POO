package Projet_POO.Service;


import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Domain.Entity.PeriodeDisponibilite;
import Projet_POO.Domain.Entity.FiltreRecherche;
import Projet_POO.Repository.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    public Vehicule creer(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    public List<Vehicule> listerDisponibles(FiltreRecherche f) {
        List<Vehicule> base = (f.getVille() != null && !f.getVille().isBlank())
                ? vehiculeRepository.findByVilleDisponibiliteIgnoreCase(f.getVille())
                : vehiculeRepository.findAll();

        List<Vehicule> res = new ArrayList<>();

        for (Vehicule v : base) {

            if (f.getNoteMin() > 0 && v.noteMoyenne() < f.getNoteMin()) continue;

            if (!f.getOptionsRequises().isEmpty() && !v.getOptions().containsAll(f.getOptionsRequises())) continue;

            if (f.getDateDebut() != null && f.getDateFin() != null) {
                if (!dispo(v.getPeriodesDisponibilite(), f.getDateDebut(), f.getDateFin())) continue;
            }

            // type/domaine/propulsion : si tu les stockes plus tard en DB, tu filtreras ici.
            res.add(v);
        }
        return res;
    }

    private boolean dispo(List<PeriodeDisponibilite> periodes, LocalDateTime debut, LocalDateTime fin) {
        if (debut == null || fin == null || !debut.isBefore(fin)) return false;

        for (PeriodeDisponibilite p : periodes) {
            if (p.getDebut() == null || p.getFin() == null) continue;
            boolean couvre = !debut.isBefore(p.getDebut()) && !fin.isAfter(p.getFin());
            if (couvre) return true;
        }
        return false;
    }
}

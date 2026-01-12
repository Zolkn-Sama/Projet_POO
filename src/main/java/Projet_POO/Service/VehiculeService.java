package Projet_POO.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Projet_POO.Domain.Entity.OptionVehicule;
import Projet_POO.Repository.OptionVehiculeRepository;
import org.springframework.stereotype.Service;

import Projet_POO.Domain.Entity.Disponibilite;
import Projet_POO.Domain.Entity.FiltreRecherche;
import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Repository.VehiculeRepository;

@Service
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final OptionVehiculeRepository optionVehiculeRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository,
                           OptionVehiculeRepository optionVehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.optionVehiculeRepository = optionVehiculeRepository;
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

            if (f.getNoteMin() > 0 && v.getNoteMoyenne() < f.getNoteMin()) continue;

            // ⚠️ correction: optionsRequises = Set<CodeOption> (enum), options = Set<OptionVehicule>
            if (!f.getOptionsRequises().isEmpty()) {
                var codesVehicule = v.getOptions().stream()
                        .map(OptionVehicule::getCode)
                        .collect(java.util.stream.Collectors.toSet());

                if (!codesVehicule.containsAll(f.getOptionsRequises())) continue;
            }

            if (f.getDateDebut() != null && f.getDateFin() != null) {
                if (!dispo(v.getDisponibilites(), f.getDateDebut(), f.getDateFin())) continue;
            }

            res.add(v);
        }
        return res;
    }

    public Vehicule ajouterOption(Long vehiculeId, Long optionId) {
        Vehicule v = vehiculeRepository.findById(vehiculeId)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable"));

        OptionVehicule opt = optionVehiculeRepository.findById(optionId)
                .orElseThrow(() -> new RuntimeException("Option introuvable"));

        v.getOptions().add(opt);
        return vehiculeRepository.save(v);
    }

    private boolean dispo(List<Disponibilite> periodes, LocalDateTime debut, LocalDateTime fin) {
        if (debut == null || fin == null || !debut.isBefore(fin)) return false;

        for (Disponibilite p : periodes) {
            if (p.getDebut() == null || p.getFin() == null) continue;
            boolean couvre = !debut.isBefore(p.getDebut()) && !fin.isAfter(p.getFin());
            if (couvre) return true;
        }
        return false;
    }
}

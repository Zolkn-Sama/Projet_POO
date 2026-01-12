package Projet_POO.Controller;

import Projet_POO.Domain.Entity.FiltreRecherche;
import Projet_POO.Domain.Entity.OptionVehicule;
import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Repository.VehiculeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recherche")
public class RechercheController {

    private final VehiculeRepository vehiculeRepo;

    public RechercheController(VehiculeRepository vehiculeRepo) {
        this.vehiculeRepo = vehiculeRepo;
    }

    @PostMapping("/vehicules")
    public List<Vehicule> rechercher(@RequestBody FiltreRecherche filtre) {

        List<Vehicule> tout = vehiculeRepo.findAll();

        return tout.stream()
                .filter(v -> filtre.getMarque() == null
                        || (v.getCaracteristiques() != null
                        && filtre.getMarque().equalsIgnoreCase(v.getCaracteristiques().getMarque())))

                .filter(v -> filtre.getModele() == null
                        || (v.getCaracteristiques() != null
                        && filtre.getModele().equalsIgnoreCase(v.getCaracteristiques().getModele())))

                .filter(v -> filtre.getCouleur() == null
                        || (v.getCaracteristiques() != null
                        && filtre.getCouleur().equalsIgnoreCase(v.getCaracteristiques().getCouleur())))

                .filter(v -> filtre.getVille() == null
                        || filtre.getVille().equalsIgnoreCase(v.getVilleDisponibilite()))
                .filter(v -> filtre.getNoteMin() <= 0
                        || v.getNoteMoyenne() >= filtre.getNoteMin())
                // options (si tu as bien OptionVehicule en @Entity + ManyToMany)
                .filter(v -> filtre.getOptionsRequises() == null || filtre.getOptionsRequises().isEmpty()
                        || v.getOptions().stream().map(OptionVehicule::getCode).collect(java.util.stream.Collectors.toSet())
                        .containsAll(filtre.getOptionsRequises()))
                // dispo
                .filter(v -> filtre.getDateDebut() == null || filtre.getDateFin() == null
                        || v.estDisponible(filtre.getDateDebut(), filtre.getDateFin()))
                .toList();


    }
}


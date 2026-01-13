package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projet_POO.Domain.Entity.FiltreRecherche;
import Projet_POO.Domain.Entity.OptionVehicule;
import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Repository.VehiculeRepository;

@RestController
@RequestMapping("/recherche")
public class RechercheController {

        private final VehiculeRepository vehiculeRepository;

        public RechercheController(VehiculeRepository vehiculeRepository) {
                this.vehiculeRepository = vehiculeRepository;
        }

        @PostMapping("/FilterVehicules")
        public List<Vehicule> rechercher(@RequestBody FiltreRecherche filtre) {

                List<Vehicule> vehicules = vehiculeRepository.findAll();

                return vehicules.stream()
                                .filter(v -> filtre.getMarque() == null
                                                || (v.getCaracteristiques() != null
                                                                && filtre.getMarque().equalsIgnoreCase(
                                                                                v.getCaracteristiques().getMarque())))

                                .filter(v -> filtre.getModele() == null
                                                || (v.getCaracteristiques() != null
                                                                && filtre.getModele().equalsIgnoreCase(
                                                                                v.getCaracteristiques().getModele())))

                                .filter(v -> filtre.getCouleur() == null
                                                || (v.getCaracteristiques() != null
                                                                && filtre.getCouleur().equalsIgnoreCase(
                                                                                v.getCaracteristiques().getCouleur())))

                                .filter(v -> filtre.getLocalisation() == null
                                                || filtre.getLocalisation().equals(v.getLocalisationVehicule()))
                                .filter(v -> filtre.getNoteMin() <= 0
                                                || v.getNoteMoyenne() >= filtre.getNoteMin())
                                // options (si tu as bien OptionVehicule en @Entity + ManyToMany)
                                .filter(v -> filtre.getOptionsRequises() == null
                                                || filtre.getOptionsRequises().isEmpty()
                                                || v.getOptions().stream().map(OptionVehicule::getCode)
                                                                .collect(java.util.stream.Collectors.toSet())
                                                                .containsAll(filtre.getOptionsRequises()))
                                // dispo
                                .filter(v -> filtre.getDateDebut() == null || filtre.getDateFin() == null
                                                || v.estDisponible(filtre.getDateDebut(), filtre.getDateFin()))
                                .toList();

        }
}

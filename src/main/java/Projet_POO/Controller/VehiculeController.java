package Projet_POO.Controller;


import Projet_POO.Domain.Enums.CodeOption;
import Projet_POO.Service.VehiculeService;
import Projet_POO.Domain.Entity.FiltreRecherche;
import Projet_POO.Domain.Entity.Vehicule;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vehicules")
public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }
    @PostMapping
    public Vehicule creer(@RequestBody Vehicule v) {
        return vehiculeService.creer(v);
    }
    @PutMapping("/{vehiculeId}/options/{optionId}")
    public Vehicule ajouterOption(@PathVariable Long vehiculeId,
                                  @PathVariable Long optionId) {
        return vehiculeService.ajouterOption(vehiculeId, optionId);
    }




    @GetMapping("/disponibles")
    public List<Vehicule> disponibles(
            @RequestParam(required = false) String ville,
            @RequestParam(required = false, defaultValue = "0") double noteMin,
            @RequestParam(required = false) List<CodeOption> options,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateDebut,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFin
    ) {
        FiltreRecherche f = new FiltreRecherche();
        f.setVille(ville);
        f.setNoteMin(noteMin);
        f.setDateDebut(dateDebut);
        f.setDateFin(dateFin);

        if (options != null) {
            for (CodeOption o : options) f.ajouterOptionRequise(o);
        }

        return vehiculeService.listerDisponibles(f);
    }
}

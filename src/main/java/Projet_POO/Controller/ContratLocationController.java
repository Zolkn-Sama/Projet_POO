package Projet_POO.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Service.VehiculeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.ContratLocation;
import Projet_POO.Service.ContratLocationService;




@RestController
@RequestMapping("/contrats")
public class ContratLocationController {

    private final ContratLocationService contratService;
    private final VehiculeService vehiculeService;

    public ContratLocationController(ContratLocationService contratService,  VehiculeService vehiculeService) {
        this.contratService = contratService;
        this.vehiculeService = vehiculeService;
    }

    @GetMapping
    public List<ContratLocation> getAll() {
        return contratService.findAll();
    }

    @GetMapping("/{id}")
    public ContratLocation getById(@PathVariable Long id) {
        return contratService.findById(id);
    }

    @GetMapping("/loueur/{loueurId}")
    public List<ContratLocation> getByLoueur(@PathVariable Long loueurId) {
        return contratService.findByLoueur(loueurId);
    }

    @GetMapping("/vehicule/{vehiculeId}")
    public List<ContratLocation> getByVehicule(@PathVariable Long vehiculeId) {
        return contratService.findByVehicule(vehiculeId);
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, Object> data) {
        try {
            ContratLocation contrat = new ContratLocation();
            Long vehiculeId = Long.valueOf(data.get("vehiculeId").toString());
            Long loueurId = Long.valueOf(data.get("loueurId").toString());

            // 1. Parsing des dates
            LocalDateTime debut = LocalDateTime.parse(data.get("dateDebut").toString());
            LocalDateTime fin = LocalDateTime.parse(data.get("dateFin").toString());

            // 2. Calcul de la durée
            long jours = java.time.temporal.ChronoUnit.DAYS.between(debut.toLocalDate(), fin.toLocalDate());
            if (jours <= 0) jours = 1;

            // 3. Récupération du véhicule et calcul du prix
            Vehicule v = vehiculeService.findById(vehiculeId);
            if (v == null) return ResponseEntity.status(404).body("Véhicule non trouvé");

            double prixTotalHT = v.getPrixJournalier();
            double tauxCommission = 10.0; // 10%

            // 4. Création de l'objet PrixLocation
            Projet_POO.Domain.Entity.PrixLocation prixDetails = new Projet_POO.Domain.Entity.PrixLocation();
            prixDetails.setPrixFix(prixTotalHT);
            prixDetails.setPourcentage(tauxCommission);
            prixDetails.recalculer();

            double montantFinalTTC = prixDetails.getMontantTotal();

            // 5. REMPLISSAGE DU CONTRAT (C'EST ICI QUE ÇA MANQUAIT)
            contrat.setVehiculeId(vehiculeId);
            contrat.setLoueurId(loueurId);
            contrat.setDateDebut(debut);  // <--- IMPORTANT : pour enregistrer la date en base
            contrat.setDateFin(fin);      // <--- IMPORTANT
            contrat.setStatut(Projet_POO.Domain.Enums.StatutContrat.EN_ATTENTE);
            contrat.setMontantTotal(montantFinalTTC);
            contrat.setMontantAPayer(montantFinalTTC);
            contrat.setPrixLocation(prixDetails);

            ContratLocation saved = contratService.create(contrat);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erreur serveur : " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ContratLocation update(@PathVariable Long id, @RequestBody ContratLocation contrat) {
        return contratService.update(id, contrat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contratService.delete(id);
    }
}

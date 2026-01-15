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

            // 1. Récupération des dates
            LocalDateTime debut = LocalDateTime.parse(data.get("dateDebut").toString());
            LocalDateTime fin = LocalDateTime.parse(data.get("dateFin").toString());
            long jours = java.time.Duration.between(debut, fin).toDays();
            if (jours <= 0) jours = 1;

            // 2. RÉCUPÉRATION DU PRIX RÉEL (SÉCURITÉ)
            // On récupère le véhicule via un service interne au lieu de croire le montant envoyé par le JS
            Vehicule v = vehiculeService.findById(vehiculeId);
            double prixReelTotal = v.getPrixJournalier() * jours;
            double commission = prixReelTotal * 0.10;
            double montantFinalHomologue = prixReelTotal + commission;

            // 3. Remplissage du contrat
            contrat.setVehiculeId(vehiculeId);
            contrat.setLoueurId(Long.valueOf(data.get("loueurId").toString()));
            contrat.setDateDebut(debut);
            contrat.setDateFin(fin);
            contrat.setStatut(Projet_POO.Domain.Enums.StatutContrat.EN_ATTENTE);
            contrat.setMontantTotal(montantFinalHomologue); // On utilise le montant calculé par le serveur

            // 4. PrixLocation
            Projet_POO.Domain.Entity.PrixLocation prixDetails = new Projet_POO.Domain.Entity.PrixLocation();
            // Optionnel : remplir les détails de prixDetails ici
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

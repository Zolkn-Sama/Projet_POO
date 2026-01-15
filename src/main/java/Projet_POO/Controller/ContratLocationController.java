package Projet_POO.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.ContratLocation;
import Projet_POO.Service.ContratLocationService;

@RestController
@RequestMapping("/contrats")
public class ContratLocationController {

    private final ContratLocationService contratService;

    public ContratLocationController(ContratLocationService contratService) {
        this.contratService = contratService;
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

            // 1. Récupération des dates et calcul de la durée
            LocalDateTime debut = LocalDateTime.parse(data.get("dateDebut").toString());
            LocalDateTime fin = LocalDateTime.parse(data.get("dateFin").toString());
            long jours = java.time.Duration.between(debut, fin).toDays();
            if (jours <= 0) jours = 1; // Sécurité pour 1 jour minimum

            // 2. Remplissage du contrat
            contrat.setVehiculeId(Long.valueOf(data.get("vehiculeId").toString()));
            contrat.setLoueurId(Long.valueOf(data.get("loueurId").toString()));
            contrat.setDateDebut(debut);
            contrat.setDateFin(fin);
            contrat.setStatut(Projet_POO.Domain.Enums.StatutContrat.valueOf(data.get("statut").toString()));
            contrat.setMontantTotal(Double.parseDouble(data.get("montantTotal").toString()));

            // 3. CRÉATION AUTOMATIQUE DU PRIX DE LOCATION
            // Cela règle l'erreur "prixLocation est obligatoire"
            Projet_POO.Domain.Entity.PrixLocation prixDetails = new Projet_POO.Domain.Entity.PrixLocation();
            // On peut ici logger ou calculer le détail si votre entité PrixLocation a des champs
            // ex: prixDetails.setMontantBase(contrat.getMontantTotal());

            contrat.setPrixLocation(prixDetails);

            // 4. Sauvegarde finale
            ContratLocation saved = contratService.create(contrat);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("Erreur : " + e.getMessage());
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

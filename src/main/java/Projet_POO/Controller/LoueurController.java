package Projet_POO.Controller;

import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Service.LoueurService;
import Projet_POO.Domain.Entity.ContratLocation;
import Projet_POO.Service.ContratLocationService;

@RestController
@RequestMapping("/loueurs")
public class LoueurController {

    private final LoueurService loueurService;
    private final ContratLocationService contratLocationService;


    public LoueurController(LoueurService loueurService, ContratLocationService contratLocationService) {
        this.loueurService = loueurService;
        this.contratLocationService = contratLocationService;
    }

    @GetMapping
    public List<Loueur> getAll() {
        return loueurService.findAll();
    }

    @GetMapping("/ById/{id}")
    public Loueur getById(@PathVariable Long id) {
        return loueurService.findById(id);
    }

    @GetMapping("/ByEmail/{email}")
    public Loueur getByEmail(@PathVariable String email) {
        return loueurService.findByEmail(email);
    }

    @PostMapping
    public Loueur create(@RequestBody Loueur loueur) {
        return loueurService.create(loueur);
    }

    @PutMapping("/{id}")
    public Loueur update(@PathVariable Long id, @RequestBody Loueur loueur) {
        return loueurService.update(id, loueur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        loueurService.delete(id);
    }

    @GetMapping("/dashboard-data")
    public ResponseEntity<?> getDashboardData(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(401).body("Non connecté");
        }

        // 1. Récupérer le loueur
        Loueur loueur = loueurService.findById(userId);

        // 2. Récupérer ses contrats (via le loueurId)
        // Note : Assure-toi que ton contratRepo possède findByLoueurId
        List<ContratLocation> sesContrats = contratLocationService.findByLoueur(userId);

        // 3. Calculer quelques stats rapides
        double totalDepense = sesContrats.stream()
                .mapToDouble(ContratLocation::getMontantTotal)
                .sum();

        long nbLocationsActives = sesContrats.stream()
                .filter(c -> c.getStatut().toString().equals("EN_COURS"))
                .count();

        // 4. Construire la réponse
        return ResponseEntity.ok(Map.of(
                "profil", loueur,
                "stats", Map.of(
                        "totalDepense", totalDepense,
                        "nbLocations", sesContrats.size(),
                        "locationsActives", nbLocationsActives
                ),
                "contrats", sesContrats
        ));
    }
}

package Projet_POO.Controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Entity.CaracteristiquesVehicule;
import Projet_POO.Domain.Entity.Localisation;
import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Domain.Entity.TypeVehicule;
import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Domain.Entity.Disponibilite;
import Projet_POO.Repository.AgentRepository;
import Projet_POO.Repository.LoueurRepository;
import Projet_POO.Service.VehiculeService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/vehicules")
public class VehiculeController {

    private final VehiculeService vehiculeService;
    private final AgentRepository agentRepository;
    private final LoueurRepository loueurRepository;
    private final jakarta.persistence.EntityManager entityManager;

    public VehiculeController(VehiculeService vehiculeService,
                              AgentRepository agentRepository,
                              LoueurRepository loueurRepository,
                              jakarta.persistence.EntityManager entityManager) {
        this.vehiculeService = vehiculeService;
        this.agentRepository = agentRepository;
        this.loueurRepository = loueurRepository;
        this.entityManager = entityManager;
    }

    @GetMapping
    public List<Vehicule> getAll() {
        return vehiculeService.findAll();
    }

    @GetMapping("/ById/{id}")
    public Vehicule getById(@PathVariable int id) {
        return vehiculeService.findById(id);
    }

    @GetMapping("/ByImmatriculation/{immatriculation}")
    public Vehicule getByImmatriculation(@PathVariable String immatriculation) {
        return vehiculeService.findByImmatriculation(immatriculation);
    }

    @PostMapping
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.create(vehicule);
    }

    @PutMapping("/{id}")
    public Vehicule update(@PathVariable Long id,
                           @RequestBody Vehicule vehicule) {
        return vehiculeService.update(id, vehicule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            vehiculeService.delete(id);
            return ResponseEntity.ok(Map.of("message", "Le véhicule a été supprimé avec succès."));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur lors de la suppression : " + e.getMessage());
        }
    }

    @Transactional
    @PostMapping("/add")
    public ResponseEntity<?> addVehicule(@RequestBody Map<String, Object> data, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(401).body("Erreur : Vous devez être connecté.");
        }

        try {
            // 1. Logique de promotion Agent
            Agent agent = agentRepository.findById(userId).orElse(null);

            if (agent == null) {
                Loueur loueur = loueurRepository.findById(userId)
                        .orElseThrow(() -> new RuntimeException("Compte loueur introuvable"));

                entityManager.createNativeQuery(
                                "INSERT INTO agent (id, nom, prenom, email, password, telephone, ville, pays, solde, est_professionnel) " +
                                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
                        .setParameter(1, loueur.getId())
                        .setParameter(2, loueur.getNom())
                        .setParameter(3, loueur.getPrenom())
                        .setParameter(4, loueur.getEmail())
                        .setParameter(5, loueur.getPassword())
                        .setParameter(6, loueur.getTelephone())
                        .setParameter(7, loueur.getVille())
                        .setParameter(8, loueur.getPays())
                        .setParameter(9, loueur.getSolde())
                        .setParameter(10, false)
                        .executeUpdate();

                agent = agentRepository.findById(userId).get();
                session.setAttribute("userRole", "AGENT");
            }

            // 2. Extraire les données Caractéristiques et Localisation
            Map<String, Object> caracMap = (Map<String, Object>) data.get("caracteristiques");
            Map<String, Object> locMap = (Map<String, Object>) data.get("localisation");

            CaracteristiquesVehicule carac = new CaracteristiquesVehicule();
            carac.setMarque((String) caracMap.get("marque"));
            carac.setModele((String) caracMap.get("modele"));
            carac.setCouleur((String) caracMap.get("couleur"));
            carac.setNbPlaces(Integer.parseInt(caracMap.get("nbPlaces").toString()));

            TypeVehicule type = new TypeVehicule((String) data.get("typeLibelle"), "Route");

            Localisation loc = new Localisation();
            loc.setRue((String) locMap.get("rue"));
            loc.setVille((String) locMap.get("ville"));
            loc.setCodePostal((String) locMap.get("codepostal"));
            loc.setPays((String) locMap.get("pays"));

            // 3. Créer l'objet Véhicule
            Vehicule vehicule = new Vehicule();
            vehicule.setPrixJournalier(Double.parseDouble(data.get("prix").toString()));
            vehicule.setImmatriculation((String) data.get("immatriculation"));
            vehicule.setCaracteristiques(carac);
            vehicule.setLocalisationVehicule(loc);
            vehicule.setTypeVehicule(type);
            vehicule.setAgent(agent);

            // --- AJOUT DES DISPONIBILITÉS ---
            String debutStr = (String) data.get("dispoDebut");
            String finStr = (String) data.get("dispoFin");

            if (debutStr != null && !debutStr.isEmpty() && finStr != null && !finStr.isEmpty()) {
                LocalDateTime debut = LocalDateTime.parse(debutStr);
                LocalDateTime fin = LocalDateTime.parse(finStr);

                Disponibilite dispo = new Disponibilite(debut, fin); //
                List<Disponibilite> listDispo = new ArrayList<>();
                listDispo.add(dispo);

                vehicule.setDisponibilites(listDispo); //
            }

            // 4. Sauvegarder
            vehiculeService.create(vehicule);

            return ResponseEntity.ok(Map.of("message", "Véhicule ajouté avec succès !"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    @GetMapping("/my-vehicles")
    public ResponseEntity<List<Vehicule>> getMyVehicles(HttpSession session) {
        Long agentId = (Long) session.getAttribute("userId");
        if (agentId == null) return ResponseEntity.status(401).build();

        return agentRepository.findById(agentId)
                .map(agent -> ResponseEntity.ok(agent.getVehicules()))
                .orElse(ResponseEntity.ok(List.of()));
    }
}
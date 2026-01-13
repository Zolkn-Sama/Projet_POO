package Projet_POO.Controller.HTML;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Contrôleur principal gérant l'accès à la page d'accueil de l'application.
 * <p>
 * Ce contrôleur répond aux requêtes sur la racine du site et sert de point
 * d'entrée
 * pour les visiteurs non authentifiés ou les utilisateurs redirigés.
 * </p>
 */
@Controller
public class HomeController {

    /**
     * Dirige l'utilisateur vers la page d'accueil.
     * <p>
     * Cette méthode fait le lien avec le moteur de template (Thymeleaf) pour
     * afficher le fichier 'home.html'.
     * </p>
     * 
     * @return Le nom logique de la vue (home).
     */
    @GetMapping("/")
    public String home() {
        return "home"; // Cherchera src/main/resources/templates/home.html
    }

    @GetMapping("/FilterVehicules")
    public String filterVehicules(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateDebut,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFin,
            @RequestParam(required = false) String categorie,
            @RequestParam(required = false) String energie,
            @RequestParam(required = false) BigDecimal prixMin,
            @RequestParam(required = false) BigDecimal prixMax,
            @RequestParam(required = false, defaultValue = "false") boolean disponible,
            Model model) {
        // TODO : utiliser ton DataRepository pour filtrer les véhicules disponibles
        // List<Vehicule> results = vehiculeRepository.findDisponibles(...);
        // model.addAttribute("vehicules", results);
        return "liste-vehicules"; // à créer
    }
}
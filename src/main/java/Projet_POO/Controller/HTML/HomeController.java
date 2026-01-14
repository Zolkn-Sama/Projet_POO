package Projet_POO.Controller.HTML;

import org.springframework.ui.Model;import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Contrôleur principal gérant l'accès à la page d'accueil.
 * Les autres routes HTML sont gérées par ViewController.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        // Récupération des attributs de session définis dans AuthController
        String userName = (String) session.getAttribute("userName");
        String userRole = (String) session.getAttribute("userRole");

        if (userName != null) {
            model.addAttribute("isConnected", true);
            model.addAttribute("prenom", userName);
            model.addAttribute("role", userRole);
        } else {
            model.addAttribute("isConnected", false);
        }

        return "home";
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
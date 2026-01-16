package Projet_POO.Controller.HTML;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

/**
 * Contrôleur principal gérant l'accès à la page d'accueil.
 * Les autres routes HTML sont gérées par ViewController.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        // Récupération des attributs de session définis dans AuthController
        String userLastName = (String) session.getAttribute("userLastName");
        String userName = (String) session.getAttribute("userName");
        String userRole = (String) session.getAttribute("userRole");

        if (userName != null) {
            model.addAttribute("isConnected", true);
            model.addAttribute("nom", userLastName);
            model.addAttribute("prenom", userName);
            model.addAttribute("role", userRole);
        } else {
            model.addAttribute("isConnected", false);
        }

        session.setAttribute("roleActif", "LOUEUR");

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

    @GetMapping("/quick/agent")
    public String quickAgent(HttpSession session) {
        Object object = session.getAttribute("userId");
        if (object != null) {
            // pas connecté → on envoie vers login avec info de rôle
            return "redirect:/dashboard-agent";
        }
        // connecté → on envoie vers le dashboard agent
        return "redirect:/login?role=AGENT";
    }

    @GetMapping("/quick/loueur")
    public String quickLoueur(HttpSession session) {
        Object object = session.getAttribute("userId");
        if (object != null) {
            // pas connecté → login
            return "redirect:/dashboard-loueur";
        }
        // connecté → dashboard loueur
        return "redirect:/login?role=LOUEUR";

    }
}
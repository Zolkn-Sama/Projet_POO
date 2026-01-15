package Projet_POO.Controller.HTML;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/dashboard-loueur")
    public String profilLoueur() {
        return "dashboard-loueur"; // Doit correspondre au NOM du fichier .html (sans l'extension)
    }

    @GetMapping("/dashboard-agent")
    public String dashboardAgent() {
        return "dashboard-agent"; // Retourne templates/dashboard-agent.html
    }

    @GetMapping("/reservation")
    public String reservation() {
        return "reservation-contrat"; // Retourne templates/reservation-contrat.html
    }

    @GetMapping("/conversation")
    public String conversation() {
        return "conversation"; // Retourne templates/conversation.html
    }

    @GetMapping("/vehicule-detail")
    public String detailVehicule() {
        return "vehicule-detail"; // Retourne templates/vehicule-detail.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Affiche login.html
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // Affiche register.html
    }

    @GetMapping("/historique")
    public String historique() {
        // Thymeleaf va chercher le fichier "src/main/resources/templates/historique.html"
        return "historique";
    }
}
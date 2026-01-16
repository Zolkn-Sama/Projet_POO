package Projet_POO.Controller.HTML;

import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Service.VehiculeService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ViewController {

    private final VehiculeService vehiculeService;

    public ViewController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping("/dashboard-loueur")
    public String profilLoueur() {
        return "dashboard-loueur"; // Doit correspondre au NOM du fichier .html (sans l'extension)
    }

    @GetMapping("/dashboard-agent")
    public String dashboardAgent() {
        return "dashboard-agent"; // Retourne templates/dashboard-agent.html
    }

    @GetMapping("/reservation")
    public String reservation(@RequestParam("vehiculeId") Long vehiculeId, Model model) {
        // On récupère le véhicule en base pour avoir son vrai prix
        Vehicule vehicule = vehiculeService.findById(vehiculeId);

        // On envoie l'objet véhicule à la page HTML
        model.addAttribute("vehicule", vehicule);
        model.addAttribute("vehiculeId", vehiculeId);

        return "reservation-contrat";
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


}
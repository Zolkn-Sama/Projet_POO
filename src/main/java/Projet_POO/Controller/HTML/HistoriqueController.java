package Projet_POO.Controller.HTML;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HistoriqueController {

    /**
     * Cette méthode gère l'affichage de la page historique.
     * Elle récupère l'ID passé dans l'URL (ex: /historique?loueurId=5)
     * et l'injecte dans la page HTML pour que le JavaScript puisse charger les données.
     */
    @GetMapping("/historique")
    public String afficherPageHistorique(@RequestParam(name = "loueurId", required = false) Long loueurId, Model model) {

        // On passe l'ID à la vue (Thymeleaf)
        // Si aucun ID n'est passé, la valeur sera null
        model.addAttribute("userId", loueurId);

        // Retourne le fichier templates/historique.html
        return "historique";
    }
}
package Projet_POO.Controller.HTML;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import Projet_POO.Domain.Entity.Utilisateur;
import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class CurrentUserController {

    @ModelAttribute("currentUser")
    public Utilisateur currentUser(HttpSession session) {
        Object u = session.getAttribute("user"); // adapte la clé si besoin
        if (u instanceof Utilisateur utilisateur) {
            return utilisateur;
        }
        return null;
    }
}

package Projet_POO.Controller.HTML;

import Projet_POO.Domain.DTO.LoginRequest;
import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Domain.Entity.Utilisateur;
import Projet_POO.Service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpSession session) {
        Utilisateur user = authService.authentifier(request.getEmail(), request.getPassword());

        if (user != null) {
            // On détermine le rôle pour la redirection
            String role = (user instanceof Agent) ? "AGENT" : "LOUEUR";

            // Stockage en session
            session.setAttribute("userId", user.getId());
            session.setAttribute("userRole", role);
            session.setAttribute("userName", user.getPrenom());

            return ResponseEntity.ok(Map.of(
                    "role", role,
                    "name", user.getPrenom(),
                    "redirect", (user instanceof Agent) ? "/dashboard-agent" : "/"
            ));
        }

        return ResponseEntity.status(401).body("Email ou mot de passe incorrect");
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> data) {
        try {
            String role = (String) data.get("role");
            String email = (String) data.get("email");
            String password = (String) data.get("password");
            String nom = (String) data.get("nom");
            String prenom = (String) data.get("prenom");

            if ("AGENT".equals(role)) {
                Agent agent = new Agent();
                agent.setEmail(email);
                agent.setPassword(password);
                agent.setNom(nom);
                agent.setPrenom(prenom);

                // Initialisation des champs obligatoires (Classe Utilisateur)
                agent.setTelephone("");
                agent.setVille("");
                agent.setPays("");
                agent.setSolde(0.0); // ACTIVÉ : Puisque c'est dans Utilisateur, l'Agent en a besoin aussi

                authService.inscrireAgent(agent);
            } else {
                Loueur loueur = new Loueur();
                loueur.setEmail(email);
                loueur.setPassword(password);
                loueur.setNom(nom);
                loueur.setPrenom(prenom);

                // Initialisation des champs obligatoires (Classe Utilisateur)
                loueur.setTelephone("");
                loueur.setVille("");
                loueur.setPays("");
                loueur.setSolde(0.0); // FIX : Évite l'erreur "Field 'solde' doesn't have a default value"

                authService.inscrireLoueur(loueur);
            }

            return ResponseEntity.ok(Map.of("message", "Inscription réussie !"));
        } catch (Exception e) {
            // Très important pour voir l'erreur précise dans la console si ça échoue encore
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erreur serveur : " + e.getMessage());
        }
    }
}
package Projet_POO.Controller.HTML;

import Projet_POO.Domain.DTO.LoginRequest;
import Projet_POO.Domain.Entity.Agent;
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
}
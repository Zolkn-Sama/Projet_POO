package Projet_POO.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Projet_POO.Domain.Entity.Localisation;
import Projet_POO.Domain.Entity.Utilisateur;
import Projet_POO.Service.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<Utilisateur> getAll() {
        return utilisateurService.findAll();
    }

    @GetMapping("/ById/{id}")
    public Utilisateur getById(@PathVariable Long id) {
        return utilisateurService.findById(id);
    }

    @GetMapping("/ByEmail/{email}")
    public Utilisateur getByEmail(@PathVariable String email) {
        return utilisateurService.findByEmail(email);
    }

    @PostMapping("/ByParam")
    public Utilisateur create(@RequestParam String nom,
                       @RequestParam String prenom,
                       @RequestParam String password,
                       @RequestParam String email,
                       @RequestParam String telephone,
                       @RequestParam String rue,
                       @RequestParam String ville,
                       @RequestParam String codePostal,
                       @RequestParam String pays,
                       @RequestParam LocalDate dateNaissance,
                       @RequestParam String numeroPermis,
                       @RequestParam LocalDate dateObtentionPermis,
                       @RequestParam double solde,
                       @RequestParam String role) {
        Utilisateur utilisateur = new Utilisateur(null, nom, prenom, password, email, telephone, new Localisation(rue, ville, codePostal, pays), dateNaissance, numeroPermis, dateObtentionPermis, solde, role);
        return utilisateurService.create(utilisateur);
    }

    @PostMapping("/")
    public Utilisateur create(@RequestParam Utilisateur utilisateur) {
        return utilisateurService.create(utilisateur);
    }

    @PutMapping("/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        return utilisateurService.update(id, utilisateur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utilisateurService.delete(id);
    }
}

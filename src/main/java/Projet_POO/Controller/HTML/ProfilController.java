package Projet_POO.Controller.HTML;

import Projet_POO.Domain.Entity.Utilisateur;
import Projet_POO.Service.UtilisateurService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfilController {

    @Autowired
    private UtilisateurService utilisateurService;

    // ---  (Affichage du profil) ---
    @GetMapping("/profil")
    public String afficherProfil(Model model, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");
        String role = (String) session.getAttribute("userRole");

        if (userId == null || role == null) { return "redirect:/login"; }

        try {
            Utilisateur user = utilisateurService.recupererUtilisateurParIdEtRole(userId, role);
            model.addAttribute("monUtilisateur", user);
            model.addAttribute("roleAffichage", role);


            // Logique pour le bouton "Retour Accueil"
            String lienRetour = "AGENT".equals(role) ? "/dashboard-agent" : "/"; // 或者 "/home"
            model.addAttribute("lienRetour", lienRetour);

            return "profil";

        } catch (Exception e) {
            model.addAttribute("errorMessage", "Erreur : " + e.getMessage());
            return "profil";
        }
    }

    // --- (Affichage du formulaire de modification) ---
    @GetMapping("/profil/edit")
    public String afficherEditProfil(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        String role = (String) session.getAttribute("userRole");

        if (userId == null) { return "redirect:/login"; }

        // 获取当前数据填入表单
        Utilisateur user = utilisateurService.recupererUtilisateurParIdEtRole(userId, role);
        model.addAttribute("monUtilisateur", user);

        return "profil-edit"; // 需要创建一个新的 HTML 文件
    }

    // --- 3. 处理保存请求 (Traitement de la mise à jour) ---
    @PostMapping("/profil/update")
    public String traiterUpdateProfil(@ModelAttribute Utilisateur formUser, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        String role = (String) session.getAttribute("userRole");


        utilisateurService.mettreAJourInfos(userId, role, formUser);


        return "redirect:/profil";
    }
}
package Projet_POO.Controller.HTML;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Entity.Conversation;
import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Domain.Entity.Utilisateur;
import Projet_POO.Service.AgentService;
import Projet_POO.Service.ConversationService;
import Projet_POO.Service.LoueurService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/conversations")
public class ConversationPageController {

    private final ConversationService conversationService;
    private final AgentService agentService;
    private final LoueurService loueurService;

    public ConversationPageController(ConversationService conversationService,
                                      AgentService agentService,
                                      LoueurService loueurService) {
        this.conversationService = conversationService;
        this.agentService = agentService;
        this.loueurService = loueurService;
    }

    @GetMapping("/nouveau")
    public String nouvelleConversation(HttpSession session, Model model) {

        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        // pour l'instant, on renvoie juste vers la liste/dernière conversation
        return "redirect:/conversations"; 
    }

    @PostMapping("/conversations")
    public String creerConversation(@RequestParam Long agentId,
                                    @RequestParam Long loueurId,
                                    HttpSession session) {

               Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        Agent agent = agentService.findById(agentId);
        Loueur loueur = loueurService.findById(loueurId);

        Conversation conversation = new Conversation();
        conversation.setAgent(agent);
        conversation.setLoueur(loueur);

        Conversation saved = conversationService.create(conversation);

        return "redirect:/conversations/" + saved.getId();
    }

    @GetMapping("/dashboard-agent/conversations")
    public String conversationsAgent(HttpSession session, Model model) {

        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        Agent agent = agentService.findById(currentUser.getId());

        List<Conversation> conversations = conversationService.findByAgent(agent);

        model.addAttribute("conversations", conversations);
        model.addAttribute("currentUser", currentUser);

        return "conversation-liste-agent";
    }

    @GetMapping("/dashboard-loueur/conversations")
    public String conversationsLoueur(HttpSession session, Model model) {

        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        Loueur loueur = loueurService.findById(currentUser.getId());

        List<Conversation> conversations = conversationService.findByLoueur(loueur);

        model.addAttribute("conversations", conversations);
        model.addAttribute("currentUser", currentUser);

        return "conversation-liste-loueur";
    }


    // 🔹 2) Depuis vehicule-detail : créer/ouvrir la conversation Agent <-> Loueur
    @GetMapping("/from-vehicule")
    public String fromVehicule(@RequestParam Long agentId,
                               @RequestParam Long vehiculeId,
                               HttpSession session) {

        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        // On considère qu'ici l'utilisateur agit comme LOU EUR
        session.setAttribute("roleActif", "LOUEUR");

        Agent agent = agentService.findById(agentId);

        Loueur loueur = loueurService.findById(currentUser.getId());

        Conversation conv = conversationService.findOrCreateBetween(agent, loueur);

        // 👉 ICI la redirection sera bien interprétée comme une vraie redirection
        return "redirect:/conversations/" + conv.getId();
    }
}

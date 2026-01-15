package Projet_POO.Controller.HTML;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Projet_POO.Domain.Entity.Message;
import Projet_POO.Domain.Entity.Utilisateur;
import Projet_POO.Service.MessageService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ConversationPageController {

    private final MessageService messageService;

    public ConversationPageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/conversations/{id}/messages")
    public String envoyerMessage(@PathVariable Long id,
                                 @RequestParam String contenu,
                                 HttpSession session) {

        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        Message msg = new Message(currentUser.getId(), contenu);
        messageService.create(id, msg); // ton service sait déjà gérer la conversationId

        return "redirect:/conversations/" + id;
    }
}

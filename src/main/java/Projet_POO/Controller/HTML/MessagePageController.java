package Projet_POO.Controller.HTML;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Projet_POO.Domain.Entity.Conversation;
import Projet_POO.Domain.Entity.Message;
import Projet_POO.Domain.Entity.Utilisateur;
import Projet_POO.Service.ConversationService;
import Projet_POO.Service.MessageService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MessagePageController {

    private final MessageService  messageService;
    private final ConversationService  conversationService;

    public MessagePageController(MessageService messageService, ConversationService  conversationService) {
        this.conversationService = conversationService;
        this.messageService = messageService;
    }

    @PostMapping("/conversation/message")
    public String envoyerMessage(@RequestParam Long conversationId,
                                 @RequestParam String contenu,
                                 HttpSession session,
                                 RedirectAttributes redirectAttributes) {

        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        // Validation mail / téléphone (optionnelle mais conseillée)
        String emailPattern = ".*[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}.*";
        String phonePattern = ".*(\\+?\\d[\\d\\s.\\-]{8,}\\d).*";

        if (contenu.matches(emailPattern) || contenu.matches(phonePattern)) {
            redirectAttributes.addFlashAttribute("messageErreur",
                    "Les adresses e-mail et numéros de téléphone ne sont pas autorisés.");
            return "redirect:/conversations/" + conversationId;
        }

        Conversation conv = conversationService.findById(conversationId);

        Message msg = new Message();
        msg.setContenu(contenu);
        msg.setUtilisateurId(currentUser.getId());
        msg.setConversation(conv);

        messageService.create(conversationId, msg);

        return "redirect:/conversations/" + conversationId;
    }
}

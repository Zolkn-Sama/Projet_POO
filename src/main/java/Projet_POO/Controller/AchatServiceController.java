package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.AchatService;
import Projet_POO.Service.AchatServiceService;

@RestController
@RequestMapping("/achats-services")
public class AchatServiceController {

    private final AchatServiceService achatService;

    public AchatServiceController(AchatServiceService achatService) {
        this.achatService = achatService;
    }

    // Payer/acheter un service avec le solde sans pouvoir achter 2 foisle meme service
    @PostMapping("/agents/{agentId}/services/{serviceId}/payer")
    public AchatService payer(@PathVariable Long agentId, @PathVariable Long serviceId) {
        return achatService.payerService(agentId, serviceId);
    }

    // Voir tous les achats d’un agent
    @GetMapping("/agents/{agentId}")
    public List<AchatService> achatsAgent(@PathVariable Long agentId) {
        return achatService.achatsAgent(agentId);
    }

    @GetMapping("/{id}")
    public AchatService get(@PathVariable Long id) {
        return achatService.getAchat(id);
    }
}

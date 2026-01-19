package Projet_POO.Service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import Projet_POO.Domain.Entity.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.AchatService;
import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Enums.StatutAchatService;
import Projet_POO.Repository.AchatServiceRepository;
import Projet_POO.Repository.AgentRepository;
import Projet_POO.Repository.ServiceRepository; 
import Projet_POO.Service.AchatServiceService;

@org.springframework.stereotype.Service
public class AchatServiceServiceImpl implements AchatServiceService {


    private final AchatServiceRepository achatRepo;
    private final AgentRepository agentRepo;
    private final ServiceRepository serviceRepo;

    public AchatServiceServiceImpl(AchatServiceRepository achatRepo,
                                   AgentRepository agentRepo,
                                   ServiceRepository serviceRepo) {
        this.achatRepo = achatRepo;
        this.agentRepo = agentRepo;
        this.serviceRepo = serviceRepo;
    }

    @Override
    @Transactional
    public AchatService payerService(Long agentId, Long serviceId) {

        // 1) empêcher double achat
        if (achatRepo.existsByAgentIdAndServiceId(agentId, serviceId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Service déjà acheté par cet agent");
        }

        // 2) vérifier agent
        Agent agent = agentRepo.findById(agentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent introuvable"));

        // 3) vérifier service
        Service service = (Service) serviceRepo.findById(serviceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service introuvable"));

        double prix = service.getPrix();
        if (prix < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Prix service invalide");
        }

        // 4) calcul solde utilisé
        double solde = agent.getSolde();
        double payeParSolde = Math.min(solde, prix);
        double restant = prix - payeParSolde;

        // 5) débiter solde (seulement ce qu'on utilise)
        agent.setSolde(solde - payeParSolde);
        agentRepo.save(agent);

        // 6) créer achat
        AchatService achat = new AchatService();
        achat.setAgentId(agentId);
        achat.setServiceId(serviceId);
        achat.setDateAchat(LocalDateTime.now());
        achat.setMontantTotal(prix);
        achat.setMontantPayeParSolde(payeParSolde);
        achat.setMontantRestant(restant);

        // Si un paiement externe “réussit”, on met PAYE même si restant > 0
        // Sinon: restant > 0 => EN_ATTENTE 
        achat.setStatut(restant == 0 ? StatutAchatService.PAYE : StatutAchatService.EN_ATTENTE);

        return achatRepo.save(achat);
    }

    @Override
    public List<AchatService> achatsAgent(Long agentId) {
        return achatRepo.findByAgentId(agentId);
    }

    @Override
    public AchatService getAchat(Long id) {
        return achatRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Achat introuvable"));
    }
}

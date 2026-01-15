package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.AchatService;

public interface AchatServiceService {

    AchatService payerService(Long agentId, Long serviceId);

    List<AchatService> achatsAgent(Long agentId);

    AchatService getAchat(Long id);
}

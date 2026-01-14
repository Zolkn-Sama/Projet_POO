package Projet_POO.Service;

import Projet_POO.Domain.Entity.ParrainageAgent;

public interface ParrainageAgentService {
    ParrainageAgent creerCode(Long parrainId);
    ParrainageAgent utiliserCode(String code, Long filleulId);
    void verifierEtCrediter(Long filleulId);
}

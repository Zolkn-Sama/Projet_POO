package Projet_POO.Service;

import Projet_POO.Domain.Entity.ParrainageLoueur;

public interface ParrainageLoueurService {
    ParrainageLoueur creerCode(Long parrainId);
    ParrainageLoueur utiliserCode(String code, Long filleulId);
    void verifierEtCrediter(Long filleulId);
}

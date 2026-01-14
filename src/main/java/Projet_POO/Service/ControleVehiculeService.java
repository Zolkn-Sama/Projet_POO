package Projet_POO.Service;

import Projet_POO.Domain.Entity.ControleVehicule;
import java.util.List;

public interface ControleVehiculeService {
    // Crée une fiche de contrôle liée à un véhicule spécifique
    ControleVehicule creer(ControleVehicule controle, Long vehiculeId);

    // Génère les alertes en cherchant la fiche par l'ID du véhicule
    List<String> genererAlertesPourVehicule(Long vehiculeId);
}
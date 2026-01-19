package Projet_POO.Service;

import Projet_POO.Domain.Entity.ControleVehicule;
import java.util.List;

public interface ControleVehiculeService {
    ControleVehicule creer(ControleVehicule controle, Long vehiculeId);
    List<String> genererAlertesPourVehicule(Long vehiculeId);
}

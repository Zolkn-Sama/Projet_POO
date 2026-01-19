package Projet_POO.Service.implementation;

import Projet_POO.Domain.Entity.ControleVehicule;
import Projet_POO.Domain.Entity.Vehicule;
import Projet_POO.Domain.Enums.TypeEntretien;
import Projet_POO.Repository.ControleVehiculeRepository;
import Projet_POO.Repository.VehiculeRepository;
import Projet_POO.Service.ControleVehiculeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ControleVehiculeServiceImpl implements ControleVehiculeService {

    private final ControleVehiculeRepository repo;
    private final VehiculeRepository vehiculeRepo; 

    public ControleVehiculeServiceImpl(ControleVehiculeRepository repo, VehiculeRepository vehiculeRepo) {
        this.repo = repo;
        this.vehiculeRepo = vehiculeRepo;
    }

    @Override
    public ControleVehicule creer(ControleVehicule controle, Long vehiculeId) {
        // 1. Vérifier si le véhicule existe
        Vehicule v = vehiculeRepo.findById(vehiculeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule introuvable avec l'ID : " + vehiculeId));

        // 2. Vérifier s'il a déjà un dossier 
        if (repo.findByVehiculeId(vehiculeId).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ce véhicule possède déjà un dossier technique.");
        }

        // 3. Associer le contrôle au véhicule
        controle.setId(null);
        controle.setVehicule(v);

        return repo.save(controle);
    }

    @Override
    public List<String> genererAlertesPourVehicule(Long vehiculeId) {
        // 1. Chercher le contrôle technique associé au véhicule 
        ControleVehicule ct = repo.findByVehiculeId(vehiculeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun dossier technique trouvé pour ce véhicule."));

        List<String> messages = new ArrayList<>();
        Integer actuel = ct.getKilometrageActuel();
        Map<TypeEntretien, Integer> hist = ct.getKmDernierEntretien();

        // Logique métier Contrôle Technique
        if (ct.getDateCT() != null && ct.getDateCT().plusYears(2).isBefore(LocalDate.now())) {
            messages.add("ALERTE : Le contrôle technique est expiré pour ce véhicule.");
        }

        // Logique métier pour Maintenance par km
        if (hist != null && actuel != null) {
            verifierSeuil(messages, TypeEntretien.PNEUS, hist, actuel, 40000);
            verifierSeuil(messages, TypeEntretien.VIDANGE, hist, actuel, 15000);
            verifierSeuil(messages, TypeEntretien.COURROIE_DISTRIBUTION, hist, actuel, 100000);
            verifierSeuil(messages, TypeEntretien.FREINS, hist, actuel, 30000);
            verifierSeuil(messages, TypeEntretien.AMORTISSEURS, hist, actuel, 80000);
        }

        return messages;
    }

    private void verifierSeuil(List<String> list, TypeEntretien type, Map<TypeEntretien, Integer> hist, int actuel, int seuil) {
        if (hist.containsKey(type)) {
            int difference = actuel - hist.get(type);
            if (difference >= seuil) {
                list.add("RECOMMANDATION [" + type + "] : Seuil de " + seuil + " km dépassé (Parcouru : " + difference + " km).");
            }
        }
    }
}

package Projet_POO.Service.implementation;

import java.util.List;

import Projet_POO.Repository.VehiculeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.ContratLocation;
import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Domain.Entity.PrixLocation;
import Projet_POO.Repository.ContratLocationRepository;
import Projet_POO.Repository.LoueurRepository;
import Projet_POO.Service.ContratLocationService;

@Service
public class ContratLocationServiceImpl implements ContratLocationService {

    private final ContratLocationRepository contratRepo;
    private final LoueurRepository loueurRepo;
    private final VehiculeRepository vehiculeRepo;

    public ContratLocationServiceImpl(ContratLocationRepository contratRepo,
                                      LoueurRepository loueurRepo, VehiculeRepository vehiculeRepo) {
        this.contratRepo = contratRepo;
        this.loueurRepo = loueurRepo;
        this.vehiculeRepo = vehiculeRepo;
    }

    @Override
    public List<ContratLocation> findAll() {
        return contratRepo.findAll();
    }

    @Override
    public ContratLocation findById(Long id) {
        return contratRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrat non trouvé"));
    }



    @Override
    public List<ContratLocation> findByVehicule(Long vehiculeId) {
        return contratRepo.findByVehiculeId(vehiculeId);
    }

    @Override
    public ContratLocation create(ContratLocation contrat) {
        if (contrat.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'id doit être null pour créer un contrat");
        }
        if (contrat.getLoueurId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "loueurId est obligatoire");
        }
        if (contrat.getPrixLocation() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "prixLocation est obligatoire");
        }

        // 1) Calculer/fixer le prix
        PrixLocation prix = contrat.getPrixLocation();
        prix.recalculer();
        contrat.setMontantTotal(prix.getMontantTotal());

        //  2) Utiliser le solde du loueur
        Loueur loueur = loueurRepo.findById(contrat.getLoueurId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur introuvable"));

        double total = contrat.getMontantTotal();
        double utilise = Math.min(loueur.getSolde(), total);

        loueur.setSolde(loueur.getSolde() - utilise);
        loueurRepo.save(loueur);

        contrat.setMontantPayeParSolde(utilise);
        contrat.setMontantAPayer(total - utilise);

        return contratRepo.save(contrat);
    }

    @Override
    public ContratLocation update(Long id, ContratLocation contrat) {
        ContratLocation existing = contratRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrat non trouvé"));

        existing.setDateDebut(contrat.getDateDebut());
        existing.setDateFin(contrat.getDateFin());
        existing.setLieuPrise(contrat.getLieuPrise());
        existing.setLieuDepose(contrat.getLieuDepose());
        existing.setStatut(contrat.getStatut());

        if (contrat.getPrixLocation() != null) {
            PrixLocation p = contrat.getPrixLocation();
            p.recalculer();
            existing.setPrixLocation(p);
            existing.setMontantTotal(p.getMontantTotal());
        } else {
            existing.setMontantTotal(contrat.getMontantTotal());
        }

        existing.setLoueurId(contrat.getLoueurId());
        existing.setVehiculeId(contrat.getVehiculeId());
        existing.setAssuranceId(contrat.getAssuranceId());


        return contratRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!contratRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrat non trouvé");
        }
        contratRepo.deleteById(id);
    }

    @Override
    public List<ContratLocation> findByLoueur(Long loueurId) {
        // 1. Récupérer les contrats depuis la base de données
        List<ContratLocation> contrats = contratRepo.findByLoueurId(loueurId);

        // 2. Remplir l'ID de l'agent pour chaque contrat
        for (ContratLocation c : contrats) {
            if (c.getVehiculeId() != null) {
                // On utilise ta méthode personnalisée du Repository
                Long agentId = vehiculeRepo.findAgentIdByVehiculeId(c.getVehiculeId());

                // On stocke l'ID dans le champ temporaire @Transient
                c.setAgentIdPourNote(agentId);
            }
        }

        // 3. Retourner la liste enrichie 
        return contrats;
    }
}

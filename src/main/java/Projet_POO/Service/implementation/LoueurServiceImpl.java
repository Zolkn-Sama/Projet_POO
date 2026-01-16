package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Domain.Entity.Utilisateur;
import Projet_POO.Repository.LoueurRepository;
import Projet_POO.Repository.UtilisateurRepository;
import Projet_POO.Service.LoueurService;

@Service
public class LoueurServiceImpl implements LoueurService {

    private final LoueurRepository loueurRepository;
    private final UtilisateurRepository utilisateurRepository;

    public LoueurServiceImpl(LoueurRepository loueurRepository, UtilisateurRepository utilisateurRepository) {
        this.loueurRepository = loueurRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public List<Loueur> findAll() {
        return loueurRepository.findAll();
    }

    @Override
    public Loueur findByUtilisateurId(Long id) {
        return loueurRepository.findByUtilisateurId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur non trouvé"));
    }

     @Override
    public Loueur findByUtilisateurEmail(String email) {
        return loueurRepository.findByUtilisateurEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur non trouvé"));
    }

    @Override
    public Loueur create(Loueur loueur) {
        loueur.setId(null);
        return loueurRepository.save(loueur);
    }

    @Override
    public Loueur create(long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable pour id = " + id));

        if (loueurRepository.findById(id).isPresent()) {
            throw new IllegalStateException("Cet utilisateur est déjà agent (id = " + id + ")");
        }

        Loueur loueur = new Loueur();
        loueur.setUtilisateur(utilisateur);
        loueur.setId(utilisateur.getId());
        
        return loueurRepository.save(loueur);
    }

    @Override
    public Loueur update(Long id, Loueur loueur) {
        Loueur existing = loueurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur non trouvé"));

        // Champs hérités de Utilisateur
        existing.getUtilisateur().setNom(loueur.getUtilisateur().getNom());
        existing.getUtilisateur().setPrenom(loueur.getUtilisateur().getPrenom());
        existing.getUtilisateur().setEmail(loueur.getUtilisateur().getEmail());
        existing.getUtilisateur().setPassword(loueur.getUtilisateur().getPassword());
        existing.getUtilisateur().setTelephone(loueur.getUtilisateur().getTelephone());
        existing.getUtilisateur().setDateNaissance(loueur.getUtilisateur().getDateNaissance());

        return loueurRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!loueurRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur non trouvé");
        }
        loueurRepository.deleteById(id);
    }

   
}

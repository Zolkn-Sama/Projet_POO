package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Repository.LoueurRepository;
import Projet_POO.Service.LoueurService;

@Service
public class LoueurServiceImpl implements LoueurService {

    private final LoueurRepository loueurRepository;

    public LoueurServiceImpl(LoueurRepository loueurRepository) {
        this.loueurRepository = loueurRepository;
    }

    @Override
    public List<Loueur> findAll() {
        return loueurRepository.findAll();
    }

    @Override
    public Loueur findById(Long id) {
        return loueurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur non trouvé"));
    }

     @Override
    public Loueur findByEmail(String email) {
        return loueurRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur non trouvé"));
    }

    @Override
    public Loueur create(Loueur loueur) {
        loueur.setId(null);
        return loueurRepository.save(loueur);
    }

    @Override
    public Loueur update(Long id, Loueur loueur) {
        Loueur existing = loueurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loueur non trouvé"));

        // Champs hérités de Utilisateur
        existing.setNom(loueur.getNom());
        existing.setPrenom(loueur.getPrenom());
        existing.setEmail(loueur.getEmail());
        existing.setPassword(loueur.getPassword());
        existing.setTelephone(loueur.getTelephone());
        existing.setDateNaissance(loueur.getDateNaissance());

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

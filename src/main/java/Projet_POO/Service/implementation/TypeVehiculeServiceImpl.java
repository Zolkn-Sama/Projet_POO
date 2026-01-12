package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.TypeVehicule;
import Projet_POO.Repository.TypeVehiculeRepository;
import Projet_POO.Service.TypeVehiculeService;

@Service
public class TypeVehiculeServiceImpl implements TypeVehiculeService {

    private final TypeVehiculeRepository typeVehiculeRepository;

    public TypeVehiculeServiceImpl(TypeVehiculeRepository typeVehiculeRepository) {
        this.typeVehiculeRepository = typeVehiculeRepository;
    }

    @Override
    public List<TypeVehicule> findAll() {
        return typeVehiculeRepository.findAll();
    }

    @Override
    public TypeVehicule findById(Long id) {
        return typeVehiculeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TypeVehicule non trouvé"));
    }

    @Override
    public TypeVehicule findByLibelle(String libelle) {
        return typeVehiculeRepository.findByLibelleIgnoreCase(libelle)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TypeVehicule non trouvé"));
    }

    @Override
    public List<TypeVehicule> findByDomaine(String domaine) {
        return typeVehiculeRepository.findByDomaineIgnoreCase(domaine);
    }

    @Override
    public TypeVehicule create(TypeVehicule typeVehicule) {
        // Ton entity n'a pas setId(), donc on ne touche pas l'id.
        // Optionnel: empêcher les doublons de libelle
        typeVehiculeRepository.findByLibelleIgnoreCase(typeVehicule.getLibelle())
                .ifPresent(tv -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Un TypeVehicule avec ce libellé existe déjà");
                });

        return typeVehiculeRepository.save(typeVehicule);
    }

    @Override
    public TypeVehicule update(Long id, TypeVehicule typeVehicule) {
        TypeVehicule existing = findById(id);

        existing.setLibelle(typeVehicule.getLibelle());
        existing.setDomaine(typeVehicule.getDomaine());

        return typeVehiculeRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!typeVehiculeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TypeVehicule non trouvé");
        }
        typeVehiculeRepository.deleteById(id);
    }
}

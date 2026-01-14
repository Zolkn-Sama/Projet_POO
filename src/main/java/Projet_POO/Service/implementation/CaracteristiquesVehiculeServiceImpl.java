package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.CaracteristiquesVehicule;
import Projet_POO.Repository.CaracteristiquesVehiculeRepository;
import Projet_POO.Service.CaracteristiquesVehiculeService;

@Service
public class CaracteristiquesVehiculeServiceImpl implements CaracteristiquesVehiculeService {

    private final CaracteristiquesVehiculeRepository caracteristiquesVehiculeRepository;

    public CaracteristiquesVehiculeServiceImpl(CaracteristiquesVehiculeRepository caracteristiquesVehiculeRepository) {
        this.caracteristiquesVehiculeRepository = caracteristiquesVehiculeRepository;
    }

    @Override
    public List<CaracteristiquesVehicule> findAll() {
        return caracteristiquesVehiculeRepository.findAll();
    }

    @Override
    public CaracteristiquesVehicule findById(Long id) {
        return caracteristiquesVehiculeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Caractéristiques véhicule non trouvées"));
    }

    @Override
    public List<CaracteristiquesVehicule> findByMarque(String marque) {
        return caracteristiquesVehiculeRepository.findByMarqueIgnoreCase(marque);
    }

    @Override
    public List<CaracteristiquesVehicule> findByModele(String modele) {
        return caracteristiquesVehiculeRepository.findByModeleIgnoreCase(modele);
    }

    @Override
    public List<CaracteristiquesVehicule> findByCouleur(String couleur) {
        return caracteristiquesVehiculeRepository.findByCouleurIgnoreCase(couleur);
    }

    @Override
    public List<CaracteristiquesVehicule> findByCategoriePermisRequise(String categoriePermisRequise) {
        return caracteristiquesVehiculeRepository.findByCategoriePermisRequiseIgnoreCase(categoriePermisRequise);
    }

    @Override
    public List<CaracteristiquesVehicule> findByNbPlaces(int nbPlaces) {
        return caracteristiquesVehiculeRepository.findByNbPlaces(nbPlaces);
    }

    @Override
    public CaracteristiquesVehicule create(CaracteristiquesVehicule caracteristiquesVehicule) {
        caracteristiquesVehicule.setId(null);
        return caracteristiquesVehiculeRepository.save(caracteristiquesVehicule);
    }


    @Override
    public CaracteristiquesVehicule update(Long id, CaracteristiquesVehicule caracteristiquesVehicule) {
        CaracteristiquesVehicule existing = findById(id);

        existing.setMarque(caracteristiquesVehicule.getMarque());
        existing.setModele(caracteristiquesVehicule.getModele());
        existing.setCouleur(caracteristiquesVehicule.getCouleur());
        existing.setCategoriePermisRequise(caracteristiquesVehicule.getCategoriePermisRequise());
        existing.setNbPlaces(caracteristiquesVehicule.getNbPlaces());

        return caracteristiquesVehiculeRepository.save(existing);
    }


    @Override
    public void delete(Long id) {
        if (!caracteristiquesVehiculeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Caractéristiques véhicule non trouvées");
        }
        caracteristiquesVehiculeRepository.deleteById(id);
    }
}

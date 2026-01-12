package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.OptionVehicule;
import Projet_POO.Domain.Enums.CodeOption;
import Projet_POO.Repository.OptionVehiculeRepository;
import Projet_POO.Service.OptionVehiculeService;

@Service
public class OptionVehiculeServiceImpl implements OptionVehiculeService {

    private final OptionVehiculeRepository optionVehiculeRepository;

    public OptionVehiculeServiceImpl(OptionVehiculeRepository optionVehiculeRepository) {
        this.optionVehiculeRepository = optionVehiculeRepository;
    }

    @Override
    public List<OptionVehicule> findAll() {
        return optionVehiculeRepository.findAll();
    }

    @Override
    public OptionVehicule findById(Long id) {
        return optionVehiculeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Option véhicule non trouvée"));
    }

    @Override
    public OptionVehicule findByCode(CodeOption code) {
        return optionVehiculeRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Option véhicule non trouvée"));
    }

    @Override
    public OptionVehicule create(OptionVehicule optionVehicule) {

        optionVehiculeRepository.findByCode(optionVehicule.getCode())
                .ifPresent(opt -> {
                    throw new ResponseStatusException(
                            HttpStatus.CONFLICT,
                            "Cette option existe déjà");
                });

        return optionVehiculeRepository.save(optionVehicule);
    }

    @Override
    public OptionVehicule update(Long id, CodeOption code) {
        OptionVehicule existing = findById(id);
        existing.setCode(code);
        return optionVehiculeRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!optionVehiculeRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Option véhicule non trouvée");
        }
        optionVehiculeRepository.deleteById(id);
    }
}

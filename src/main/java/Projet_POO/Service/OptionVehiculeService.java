package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.OptionVehicule;
import Projet_POO.Domain.Enums.CodeOption;

public interface OptionVehiculeService {

    List<OptionVehicule> findAll();
    OptionVehicule findById(Long id);
    OptionVehicule findByCode(CodeOption code);

    OptionVehicule create(OptionVehicule optionVehicule);
    OptionVehicule update(Long id, CodeOption code);
    void delete(Long id);
}

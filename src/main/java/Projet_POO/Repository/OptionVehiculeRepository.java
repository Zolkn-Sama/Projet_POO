package Projet_POO.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.OptionVehicule;
import Projet_POO.Domain.Enums.CodeOption;

@Repository
public interface OptionVehiculeRepository extends JpaRepository<OptionVehicule, Long> {

    Optional<OptionVehicule> findByCode(CodeOption code);
}

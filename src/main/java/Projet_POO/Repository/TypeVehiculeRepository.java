package Projet_POO.Repository;

import Projet_POO.Domain.Entity.TypeVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

public interface TypeVehiculeRepository extends JpaRepository<TypeVehicule, Long> {
}
=======
import org.springframework.stereotype.Repository;

@Repository
public interface TypeVehiculeRepository extends JpaRepository<TypeVehicule, Integer> {
    // Permet de retrouver un type par son libelle (ex: "Bateau")
    TypeVehicule findByLibelleIgnoreCase(String libelle);
}
>>>>>>> ALEX

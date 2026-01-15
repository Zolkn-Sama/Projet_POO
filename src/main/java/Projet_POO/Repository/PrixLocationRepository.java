package Projet_POO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Projet_POO.Domain.Entity.PrixLocation;

@Repository
public interface PrixLocationRepository extends JpaRepository<PrixLocation, Long> {
}

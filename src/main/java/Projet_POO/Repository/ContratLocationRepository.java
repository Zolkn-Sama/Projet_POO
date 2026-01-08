package Projet_POO.Repository;


import Projet_POO.Domain.Entity.ContratLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface ContratLocationRepository extends JpaRepository<ContratLocation, Long>{
}



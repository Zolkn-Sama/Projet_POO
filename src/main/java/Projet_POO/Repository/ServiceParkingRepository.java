package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.ServiceParking;

@Repository
public interface ServiceParkingRepository extends JpaRepository<ServiceParking, Long> {
    
    List<ServiceParking> findAll();
    Optional<ServiceParking> findById(Long id);
}

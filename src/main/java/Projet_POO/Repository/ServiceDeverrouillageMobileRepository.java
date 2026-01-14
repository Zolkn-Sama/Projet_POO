package Projet_POO.Repository;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.ServiceDeverrouillageMobile;

@Repository
public interface ServiceDeverrouillageMobileRepository extends JpaRepository<ServiceDeverrouillageMobile, Long> {
    List<ServiceDeverrouillageMobile> findAll();
    Optional<ServiceDeverrouillageMobile> findById(Long id);
=======
import Projet_POO.Domain.Entity.ServiceDeverrouillageMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDeverrouillageMobileRepository extends JpaRepository<ServiceDeverrouillageMobile, Long> {
>>>>>>> ALEX
}

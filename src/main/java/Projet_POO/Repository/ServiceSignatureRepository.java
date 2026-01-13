package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.ServiceSignature;

@Repository
public interface ServiceSignatureRepository extends JpaRepository<ServiceSignature, Long> {
    List<ServiceSignature> findAll();
    Optional<ServiceSignature> findById(Long id);
}

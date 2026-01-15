package Projet_POO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}

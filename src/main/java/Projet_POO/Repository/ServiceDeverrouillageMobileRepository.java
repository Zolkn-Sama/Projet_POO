package Projet_POO.Repository;

import Projet_POO.Domain.Entity.ServiceDeverrouillageMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDeverrouillageMobileRepository extends JpaRepository<ServiceDeverrouillageMobile, Long> {
}

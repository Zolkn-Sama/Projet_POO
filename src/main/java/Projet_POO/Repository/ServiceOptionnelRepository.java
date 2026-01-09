package Projet_POO.Repository;

import Projet_POO.Domain.Entity.ServiceOptionnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceOptionnelRepository extends JpaRepository<ServiceOptionnel, Long> {


}


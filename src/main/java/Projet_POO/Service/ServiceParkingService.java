package Projet_POO.Service;

import Projet_POO.Domain.Entity.ServiceParking;

import java.util.List;

public interface ServiceParkingService {

    List<ServiceParking> findAll();

    ServiceParking findById(Long id);

    ServiceParking create(ServiceParking serviceParking);

    ServiceParking update(Long id, ServiceParking serviceParking);

    void delete(Long id);
}

package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.ServiceDepotVehicule;

public interface ServiceDepotVehiculeService {

    List<ServiceDepotVehicule> findAll();

    ServiceDepotVehicule findById(Long id);

    ServiceDepotVehicule create(ServiceDepotVehicule serviceDepotVehicule);

    ServiceDepotVehicule update(Long id, ServiceDepotVehicule serviceDepotVehicule);

    void delete(Long id);
}

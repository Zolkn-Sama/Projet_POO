package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.ServiceDeverrouillageMobile;

public interface ServiceDeverrouillageMobileService {

    List<ServiceDeverrouillageMobile> findAll();

    ServiceDeverrouillageMobile findById(Long id);

    ServiceDeverrouillageMobile create(ServiceDeverrouillageMobile serviceDeverrouillageMobile);

    ServiceDeverrouillageMobile update(Long id, ServiceDeverrouillageMobile serviceDeverrouillageMobile);

    void delete(Long id);
}
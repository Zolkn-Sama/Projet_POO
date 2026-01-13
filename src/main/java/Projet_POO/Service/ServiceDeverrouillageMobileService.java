package Projet_POO.Service;

import Projet_POO.Domain.Entity.ServiceDeverrouillageMobile;

import java.util.List;

public interface ServiceDeverrouillageMobileService {

    List<ServiceDeverrouillageMobile> findAll();

    ServiceDeverrouillageMobile findById(Long id);

    ServiceDeverrouillageMobile create(ServiceDeverrouillageMobile serviceDeverrouillageMobile);

    ServiceDeverrouillageMobile update(Long id, ServiceDeverrouillageMobile serviceDeverrouillageMobile);

    void delete(Long id);
}

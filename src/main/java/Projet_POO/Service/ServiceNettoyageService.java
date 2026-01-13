package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.ServiceNettoyage;

public interface ServiceNettoyageService {

    List<ServiceNettoyage> findAll();

    ServiceNettoyage findById(Long id);

    ServiceNettoyage create(ServiceNettoyage serviceNettoyage);

    ServiceNettoyage update(Long id, ServiceNettoyage serviceNettoyage);

    void delete(Long id);
}

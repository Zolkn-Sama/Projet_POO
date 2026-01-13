package Projet_POO.Service;

import Projet_POO.Domain.Entity.ServiceSignature;

import java.util.List;

public interface ServiceSignatureService {

    List<ServiceSignature> findAll();

    ServiceSignature findById(Long id);

    ServiceSignature create(ServiceSignature serviceSignature);

    ServiceSignature update(Long id, ServiceSignature serviceSignature);

    void delete(Long id);
}

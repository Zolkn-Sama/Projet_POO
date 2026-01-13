package Projet_POO.Service;

import java.util.List;
import Projet_POO.Domain.Entity.SystemePropulsion;

public interface SystemePropulsionService {
    List<SystemePropulsion> findAll();
    SystemePropulsion findById(Long id);
    SystemePropulsion create(SystemePropulsion systeme);
    void delete(Long id);
}
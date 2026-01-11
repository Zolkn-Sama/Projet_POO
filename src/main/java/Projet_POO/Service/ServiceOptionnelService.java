package Projet_POO.Service;

import Projet_POO.Domain.Entity.ServiceOptionnel;
import Projet_POO.Repository.ServiceOptionnelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOptionnelService {

    private final ServiceOptionnelRepository repo;

    public ServiceOptionnelService(ServiceOptionnelRepository repo) {
        this.repo = repo;
    }

    public ServiceOptionnel creer(ServiceOptionnel s) {
        return repo.save(s);
    }

    public List<ServiceOptionnel> tous() {
        return repo.findAll();
    }
}

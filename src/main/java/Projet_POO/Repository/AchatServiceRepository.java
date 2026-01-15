package Projet_POO.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projet_POO.Domain.Entity.AchatService;
import Projet_POO.Domain.Enums.StatutAchatService;

@Repository
public interface AchatServiceRepository extends JpaRepository<AchatService, Long> {

    boolean existsByAgentIdAndServiceId(Long agentId, Long serviceId);

    Optional<AchatService> findByAgentIdAndServiceId(Long agentId, Long serviceId);

    List<AchatService> findByAgentId(Long agentId);

    List<AchatService> findByAgentIdAndStatut(Long agentId, StatutAchatService statut);
}

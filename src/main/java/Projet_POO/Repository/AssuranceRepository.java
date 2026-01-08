package Projet_POO.Repository;

import Projet_POO.Domain.Entity.Assurance; // 确保导入路径正确
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssuranceRepository extends JpaRepository<Assurance, Long> {


}
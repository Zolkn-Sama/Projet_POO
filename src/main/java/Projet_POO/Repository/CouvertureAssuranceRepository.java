package Projet_POO.Repository;

import Projet_POO.Domain.Entity.CouvertureAssurance; // 确保导入路径正确
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CouvertureAssuranceRepository extends JpaRepository<CouvertureAssurance, Long> {


}


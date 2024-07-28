package project.qrscan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.qrscan.Entitiy.Milk;

public interface MilkRepository extends JpaRepository<Milk, Long> {
}

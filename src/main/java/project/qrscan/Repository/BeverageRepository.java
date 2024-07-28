package project.qrscan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.qrscan.Entitiy.Beverage;

public interface BeverageRepository extends JpaRepository<Beverage, Long> {
}

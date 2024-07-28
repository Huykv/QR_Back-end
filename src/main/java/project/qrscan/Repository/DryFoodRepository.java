package project.qrscan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.qrscan.Entitiy.DryFood;

public interface DryFoodRepository extends JpaRepository<DryFood, Long> {
}

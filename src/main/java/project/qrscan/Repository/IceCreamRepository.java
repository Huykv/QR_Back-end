package project.qrscan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.qrscan.Entitiy.IceCream;

public interface IceCreamRepository extends JpaRepository<IceCream, Long> {
}

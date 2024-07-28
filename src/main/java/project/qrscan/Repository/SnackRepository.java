package project.qrscan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import project.qrscan.Entitiy.Snack;

@Service
public interface SnackRepository extends JpaRepository<Snack, Long> {
}

package project.qrscan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.qrscan.Entitiy.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT id FROM product", nativeQuery = true)
    List<Long> getListIdProduct();

    @Query(value = "SELECT DISTINCT type FROM product", nativeQuery = true)
    List<String> listTypesProduct();

    @Query(value = "SELECT id FROM product\n" +
            "ORDER BY id DESC\n" +
            "LIMIT 1;", nativeQuery = true)
    Long getNextId();
}

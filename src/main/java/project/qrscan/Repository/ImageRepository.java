package project.qrscan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.qrscan.Entitiy.ImageProduct;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageProduct, Long> {
    Optional<ImageProduct> findByName(String name);

    Optional<ImageProduct> findByProductId(Long product_id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM image_product WHERE product_id = :productId", nativeQuery = true)
    void deleteByProductId(@Param("productId") Long productId);
}

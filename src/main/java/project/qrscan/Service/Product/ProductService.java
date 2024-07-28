package project.qrscan.Service.Product;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public abstract ResponseEntity<?> findById(Long id);
    public abstract ResponseEntity<List<?>> listProductsByType(String type);
    public abstract ResponseEntity<?> deleteProduct(Long id);
    public abstract ResponseEntity<?> listTypesProduct();
}

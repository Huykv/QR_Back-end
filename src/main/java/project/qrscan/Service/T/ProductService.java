package project.qrscan.Service.T;

import org.springframework.http.ResponseEntity;

public interface ProductService<T> {
    public abstract ResponseEntity<T> create(T product);
    public abstract ResponseEntity<T> update(Long id, T product);
}

package project.qrscan.Service.T;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.qrscan.Entitiy.Snack;
import project.qrscan.Repository.SnackRepository;
import project.qrscan.Repository.ImageRepository;
import project.qrscan.Service.Image.ImageService;

import java.util.Optional;

@Service
public class SnackService implements ProductService<Snack> {
    @Autowired
    private SnackRepository snackRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public ResponseEntity<Snack> create(Snack product) {
        snackRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @Override
    public ResponseEntity<Snack> update(Long id, Snack product) {
        Optional<Snack> snack = snackRepository.findById(id);
        if (snack.isEmpty()) {
            throw new RuntimeException("Not found snack id: " + id);
        }
        product.setId(id);
        snackRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}

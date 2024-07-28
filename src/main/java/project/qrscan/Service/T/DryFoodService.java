package project.qrscan.Service.T;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.qrscan.Entitiy.DryFood;
import project.qrscan.Repository.DryFoodRepository;
import project.qrscan.Repository.ImageRepository;
import project.qrscan.Service.Image.ImageService;

import java.util.Optional;

@Service
public class DryFoodService implements ProductService<DryFood> {
    @Autowired
    private DryFoodRepository dryFoodRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public ResponseEntity<DryFood> create(DryFood product) {
        dryFoodRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @Override
    public ResponseEntity<DryFood> update(Long id, DryFood product) {
        Optional<DryFood> dryFood = dryFoodRepository.findById(id);
        if (dryFood.isEmpty()) {
            throw new RuntimeException("Not found dry food id: " + id);
        }
        product.setId(id);
        dryFoodRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}

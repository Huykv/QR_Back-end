package project.qrscan.Service.T;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.qrscan.Entitiy.Beverage;
import project.qrscan.Repository.BeverageRepository;
import project.qrscan.Repository.ImageRepository;
import project.qrscan.Service.Image.ImageService;

import java.util.Optional;

@Service
public class BeverageService implements ProductService<Beverage> {
    @Autowired
    private BeverageRepository beverageRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public ResponseEntity<Beverage> create(Beverage product) {
        beverageRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @Override
    public ResponseEntity<Beverage> update(Long id, Beverage product) {
        Optional<Beverage> beverage = beverageRepository.findById(id);
        if (beverage.isEmpty()) {
            throw new RuntimeException("Not found beverage id: " + id);
        }
        product.setId(id);
        beverageRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}

package project.qrscan.Service.T;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.qrscan.Entitiy.Milk;
import project.qrscan.Repository.MilkRepository;
import project.qrscan.Repository.ImageRepository;
import project.qrscan.Service.Image.ImageService;

import java.util.Optional;

@Service
public class MilkService implements ProductService<Milk>{
    @Autowired
    private MilkRepository milkRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public ResponseEntity<Milk> create(Milk product) {
        milkRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @Override
    public ResponseEntity<Milk> update(Long id, Milk product) {
        Optional<Milk> milk = milkRepository.findById(id);
        if (milk.isEmpty()) {
            throw new RuntimeException("Not found milk id: " + id);
        }
        product.setId(id);
        milkRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}

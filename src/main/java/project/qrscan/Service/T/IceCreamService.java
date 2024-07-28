package project.qrscan.Service.T;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.qrscan.Entitiy.IceCream;
import project.qrscan.Repository.IceCreamRepository;
import project.qrscan.Repository.ImageRepository;
import project.qrscan.Service.Image.ImageService;

import java.util.Optional;

@Service
public class IceCreamService implements ProductService<IceCream> {
    @Autowired
    private IceCreamRepository iceCreamRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public ResponseEntity<IceCream> create(IceCream product) {
        iceCreamRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @Override
    public ResponseEntity<IceCream> update(Long id, IceCream product) {
        Optional<IceCream> iceCream = iceCreamRepository.findById(id);
        if (iceCream.isEmpty()) {
            throw new RuntimeException("Not found ice cream id: " + id);
        }
        product.setId(id);
        iceCreamRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}

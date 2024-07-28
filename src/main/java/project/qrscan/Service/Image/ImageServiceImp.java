package project.qrscan.Service.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import project.qrscan.Entitiy.ImageProduct;
import project.qrscan.Entitiy.Product;
import project.qrscan.Repository.ImageRepository;
import project.qrscan.Repository.ProductRepository;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImp implements ImageService{
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<?> uploadImage(MultipartFile file, Long productId) throws IOException {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            throw new RuntimeException("Not found product id: " + productId);
        }

        Optional<ImageProduct> imageProduct = imageRepository.findByProductId(productId);
        //Update image
        if (imageProduct.isPresent()) {
            ImageProduct iP = imageProduct.get();
            iP.setName(file.getOriginalFilename());
            iP.setType(file.getContentType());
            iP.setImageData(ImageUtils.compressImage(file.getBytes()));
            iP.setProduct(product.get());
            imageRepository.save(iP);
            return ResponseEntity.status(HttpStatus.OK).body("Update successful: " + file.getOriginalFilename());
        }
        //Upload image
        imageRepository.save(
                ImageProduct.builder().name(file.getOriginalFilename()).type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes())).product(product.get()).build()
        );
        return ResponseEntity.status(HttpStatus.OK).body("Upload successful: " + file.getOriginalFilename());
    }

    @Override
    public ResponseEntity<?> uploadImg(byte[] imagedata, Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            throw new RuntimeException("Not found product id: " + productId);
        }
        Optional<ImageProduct> imageProduct = imageRepository.findByProductId(productId);
        //Update image
        if (imageProduct.isPresent()) {
            ImageProduct iP = imageProduct.get();
            iP.setName(imageProduct.get().getName());
            iP.setType(imageProduct.get().getType());
            iP.setImageData(imagedata);
            iP.setProduct(product.get());
            imageRepository.save(iP);
            return ResponseEntity.status(HttpStatus.OK).body("Update successful: " + imageProduct.get().getName());
        }
        //Upload image
        imageRepository.save(
                ImageProduct.builder().name("newImg").type("image/png")
                        .imageData(imagedata).product(product.get()).build()
        );
        return ResponseEntity.status(HttpStatus.OK).body("Upload successful: newImg");
    }

    @Override
    public ResponseEntity<?> downloadImageByName(String filename) {
        Optional<ImageProduct> imageProduct = imageRepository.findByName(filename);
        if (imageProduct.isPresent()) {
            byte[] images = ImageUtils.decompressImage(imageProduct.get().getImageData());
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.valueOf("image/png"))
                    .body(images);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found image name: " + filename);
    }

    @Override
    public ResponseEntity<?> downloadImageByProductId(Long product_id) {
        Optional<ImageProduct> imageProduct = imageRepository.findByProductId(product_id);
        if (imageProduct.isPresent()) {
            byte[] images = ImageUtils.decompressImage(imageProduct.get().getImageData());
            return ResponseEntity.status(HttpStatus.OK)
//                    .contentType(MediaType.valueOf("image/png"))
                    .body(images);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found image product id: " + product_id);
    }

    @Override
    public ResponseEntity<?> deleteImage(Long product_id) {
        Optional<ImageProduct> image = imageRepository.findByProductId(product_id);
        if (image.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Not found image product id: " + product_id));
        }
        imageRepository.deleteByProductId(product_id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully images product id: " + product_id);
    }
}

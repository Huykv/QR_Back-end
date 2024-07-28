package project.qrscan.Service.Image;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    public abstract ResponseEntity<?> uploadImage(MultipartFile file, Long productId) throws IOException;
    public abstract ResponseEntity<?> uploadImg(byte[] imagedata, Long productId);
    public abstract ResponseEntity<?> downloadImageByName(String filename);
    public abstract ResponseEntity<?> downloadImageByProductId(Long product_id);
    public abstract ResponseEntity<?> deleteImage(Long product_id);
}

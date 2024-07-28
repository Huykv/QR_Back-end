package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.qrscan.Service.Image.ImageService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/{productId}")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @PathVariable Long productId) throws IOException {
        return imageService.uploadImage(file, productId);
    }

    @PostMapping("/upload/{productId}")
    public ResponseEntity<?> uploadImg(@RequestBody byte[] imagedata, @PathVariable Long productId) throws IOException {
        return imageService.uploadImg(imagedata, productId);
    }

    @GetMapping("/name/{filename}")
    public ResponseEntity<?> downloadImageByName(@PathVariable String filename){
        return imageService.downloadImageByName(filename);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<?> downloadImageByProductId(@PathVariable Long product_id) {
        return imageService.downloadImageByProductId(product_id);
    }
}

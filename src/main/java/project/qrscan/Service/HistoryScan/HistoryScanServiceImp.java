package project.qrscan.Service.HistoryScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.qrscan.Entitiy.HistoryScan;
import project.qrscan.Entitiy.Product;
import project.qrscan.Repository.HistoryScanRepository;
import project.qrscan.Repository.ProductRepository;
import project.qrscan.Service.Product.ProductService;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class HistoryScanServiceImp implements HistoryScanService{

    @Autowired
    private HistoryScanRepository historyScanRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<Map<Long, Integer>> getTimesScanProduct() {
        List<Long> listIdProduct = productRepository.getListIdProduct();
        Map<Long, Integer> map = new HashMap<>();
        for (Long product_id:listIdProduct) {
            map.put(product_id, historyScanRepository.getTimesScanProduct(product_id));
        }
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @Override
    public ResponseEntity<Map<Long, Integer>> getTimesScanProductInMonth(Integer year, Integer month) {
        List<Long> listIdProduct = productRepository.getListIdProduct();
        Map<Long, Integer> map = new HashMap<>();
        for (Long product_id:listIdProduct) {
            map.put(product_id, historyScanRepository.getTimesScanProductInMonth(year, month, product_id));
        }
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @Override
    public ResponseEntity<Map<Long, Integer>> getTimesScanProductInYear(Integer year) {
        List<Long> listIdProduct = productRepository.getListIdProduct();
        Map<Long, Integer> map = new HashMap<>();
        for (Long product_id:listIdProduct) {
            map.put(product_id, historyScanRepository.getTimesScanProductInYear(year, product_id));
        }
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @Override
    public ResponseEntity<?> scanQR(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new RuntimeException("Not found product id: " + id);
        }
        historyScanRepository.save(HistoryScan.builder().timeScan(LocalDateTime.now()).product(product.get()).build());
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}

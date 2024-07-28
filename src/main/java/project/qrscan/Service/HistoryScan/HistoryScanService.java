package project.qrscan.Service.HistoryScan;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface HistoryScanService {
    public abstract ResponseEntity<Map<Long, Integer>> getTimesScanProduct();
    public abstract ResponseEntity<Map<Long, Integer>> getTimesScanProductInMonth(Integer year, Integer month);
    public abstract ResponseEntity<Map<Long, Integer>> getTimesScanProductInYear(Integer year);
    public abstract ResponseEntity<?> scanQR(Long id);
}

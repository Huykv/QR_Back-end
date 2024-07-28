package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.qrscan.Service.HistoryScan.HistoryScanService;
import project.qrscan.Service.HistoryScan.HistoryScanServiceImp;
import project.qrscan.Service.T.BeverageService;

@RestController
@RequestMapping("/api/v1/history_scans")
public class HistoryScanController {
    @Autowired
    private HistoryScanServiceImp historyScanServiceImp;

    @GetMapping
    public ResponseEntity<?> getTimesScanProduct() {
        return historyScanServiceImp.getTimesScanProduct();
    }

    @GetMapping("/month")
    public ResponseEntity<?> getTimesScanProductInMonth(@RequestParam(name = "year") Integer year,
                                                        @RequestParam(name = "month") Integer month) {
        return historyScanServiceImp.getTimesScanProductInMonth(year, month);
    }

    @GetMapping("/year")
    public ResponseEntity<?> getTimesScanProductInYear(@RequestParam(name = "year") Integer year) {
        return historyScanServiceImp.getTimesScanProductInYear(year);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> scanQR(@PathVariable Long id) {
        return historyScanServiceImp.scanQR(id);
    }
}

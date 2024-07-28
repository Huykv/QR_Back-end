package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import project.qrscan.Entitiy.Beverage;
import project.qrscan.Service.T.BeverageService;

@RestController
@RequestMapping("/api/v1/beverages")
public class BeverageController {
    @Autowired
    private BeverageService beverageService;

    @PostMapping
    public ResponseEntity<?> addBeverage(@RequestBody Beverage beverage) {
        return beverageService.create(beverage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBeverage(@PathVariable Long id, @RequestBody Beverage beverage) {
        return beverageService.update(id, beverage);
    }

}

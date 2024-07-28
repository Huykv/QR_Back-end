package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.qrscan.Entitiy.Milk;
import project.qrscan.Service.T.MilkService;

@RestController
@RequestMapping("api/v1/milks")
public class MilkController {
    @Autowired
    private MilkService milkService;

    @PostMapping
    public ResponseEntity<?> addMilk(@RequestBody Milk milk) {
        return milkService.create(milk);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMilk(@PathVariable Long id, @RequestBody Milk milk) {
        return milkService.update(id, milk);
    }

}

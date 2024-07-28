package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.qrscan.Entitiy.DryFood;
import project.qrscan.Entitiy.DryFood;
import project.qrscan.Repository.DryFoodRepository;
import project.qrscan.Service.T.DryFoodService;

@RestController
@RequestMapping("/api/v1/dry_foods")
public class DryFoodController {
    @Autowired
    private DryFoodService dryFoodService;

    @PostMapping()
    public ResponseEntity<?> addDryFood(@RequestBody DryFood dryFood) {
        return dryFoodService.create(dryFood);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDryFood(@PathVariable Long id, @RequestBody DryFood dryFood) {
        return dryFoodService.update(id, dryFood);
    }

}

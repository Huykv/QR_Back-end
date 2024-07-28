package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.qrscan.Entitiy.Snack;
import project.qrscan.Repository.SnackRepository;
import project.qrscan.Service.T.SnackService;

@RestController
@RequestMapping("/api/v1/snacks")
public class SnackController {
    @Autowired
    private SnackService snackService;

    @PostMapping()
    public ResponseEntity<?> addSnack(@RequestBody Snack snack) {
        return snackService.create(snack);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSnack(@PathVariable Long id, @RequestBody Snack snack) {
        return snackService.update(id, snack);
    }

}

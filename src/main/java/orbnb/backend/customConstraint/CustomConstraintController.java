package orbnb.backend.customConstraint;

import orbnb.backend.customConstraint.service.CustomConstraintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customConstraintApi")
public class CustomConstraintController {

    @Autowired
    private CustomConstraintService customConstraintService;

    @PostMapping("/addCustomConstraint")
    public ResponseEntity<CustomConstraint> addCustomConstraint(@RequestBody CustomConstraint customConstraint) {
        return new ResponseEntity<>(this.customConstraintService.addCustomConstraint(customConstraint), HttpStatus.CREATED);
    }

    @GetMapping("/getCustomConstraintByLinkedHousingId/{linkedHousingId}")
    public ResponseEntity<List<CustomConstraint>> getCustomConstraintsByLinkedHousingId(@PathVariable("linkedHousingId") Long linkedHousingId){
        return new ResponseEntity<>(this.customConstraintService.getCustomConstraintByLinkedHousingId(linkedHousingId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomConstraint/{customConstraintId}")
    public void removeCustomConstraint(@PathVariable("customConstraintId") Long customConstraintId){
        this.customConstraintService.deleteCustomConstraint(customConstraintId);
    }
}

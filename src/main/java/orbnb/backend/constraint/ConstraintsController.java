package orbnb.backend.constraint;

import orbnb.backend.constraint.service.ConstraintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/constraintApi")
public class ConstraintsController {

    @Autowired
    private ConstraintsService constraintsService;

    @PostMapping("/addConstraint")
    public ResponseEntity<Constraints> addConstraint(@RequestBody Constraints constraints) {
        return new ResponseEntity<>(this.constraintsService.addConstraint(constraints), HttpStatus.CREATED);
    }

    @GetMapping("/getAllConstraints")
    public ResponseEntity<List<Constraints>> getConstraints() {
        return new ResponseEntity<>(this.constraintsService.getAllServices(), HttpStatus.OK);
    }

    @GetMapping("/getCosntraintById/{constraintId}")
    public ResponseEntity<Optional<Constraints>> getConstraint(@PathVariable("constraintId") Long constraintId) {
        return new ResponseEntity<>(this.constraintsService.getConstraintById(constraintId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteConstraint/{constraintId}")
    public void removeConstraint(@PathVariable("constraintId") Long constraintId) {
        this.constraintsService.deleteConstraint(constraintId);
    }

}

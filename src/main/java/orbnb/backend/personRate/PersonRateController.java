package orbnb.backend.personRate;

import orbnb.backend.personRate.service.PersonRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/personRateApi")
public class PersonRateController {

    @Autowired
    private PersonRateService personRateService;

    @GetMapping("/getAllPersonRates")
    public ResponseEntity<List<PersonRate>> getPersonRate() {
        return new ResponseEntity<>(this.personRateService.getAllPersonRate(), HttpStatus.OK);
    }

    @GetMapping("/getPersonRateById/{personRateId}")
    public ResponseEntity<Optional<PersonRate>> getPersonRate(@PathVariable("personRateId") Long personRateId) {
        return new ResponseEntity<>(this.personRateService.getPersonRateById(personRateId), HttpStatus.OK);
    }

    @GetMapping("/getPersonAverageNote/{notedPersonId}")
    public ResponseEntity<Double> getPersonAverageNote(@PathVariable("notedPersonId") Long notedPersonId){
        return new ResponseEntity<>(this.personRateService.getPersonAverageNote(notedPersonId), HttpStatus.OK);
    }

    @PostMapping("/addPersonRate")
    public ResponseEntity<PersonRate> addPersonRate(@RequestBody PersonRate personRate) {
        return new ResponseEntity<>(this.personRateService.addPersonRate(personRate), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePersonRate/{personRateId}")
    public void removePersonRate(@PathVariable("personRateId") Long personRateId) {
        this.personRateService.deletePersonRate(personRateId);
    }
}

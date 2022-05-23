package orbnb.backend.person;

import orbnb.backend.housing.service.HousingService;
import orbnb.backend.message.Message;
import orbnb.backend.message.service.MessageService;
import orbnb.backend.person.service.PersonService;
import orbnb.backend.personRate.service.PersonRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("personApi/")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRateService personRateService;

    @Autowired
    private HousingService housingService;

    @Autowired
    private MessageService messageService;


    @GetMapping("getAllPersons")
    public ResponseEntity<List<Person>> getPersons() {
        return new ResponseEntity<>(this.personService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping("getPersonById/{personId}")
    public ResponseEntity<Optional<Person>> getPersonById(@PathVariable long personId) {
        return new ResponseEntity<>(this.personService.getPersonById(personId), HttpStatus.OK);
    }

    @GetMapping("getPersonByLogin/{login}")
    public ResponseEntity<Person> getPersonByLogin(@PathVariable String login) {
        return new ResponseEntity<>(this.personService.getPersonByLogin(login), HttpStatus.OK);
    }

    @PostMapping("addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person newPerson) {
        return new ResponseEntity<>(personService.addPerson(newPerson), HttpStatus.CREATED);
    }

    @DeleteMapping("deletePerson/{personId}")
    void deletePerson(@PathVariable Long personId) {
        personService.deletePerson(personId);
    }

    @PutMapping("assign-person-rate/{personrate-id}/{person-id}")
    public void assignPersonRate(@PathVariable("personrate-id") Long personrate_id, @PathVariable("person-id") Long person_id) {
        personRateService.assignRateToPerson(personrate_id, person_id);
    }

    @PutMapping("assignHousing/{personId}/{housingId}")
    public void assignHousingToPerson(@PathVariable("personId") Long personId, @PathVariable("housingId") Long housingId) {
        this.housingService.assignHousingToPerson(personId, housingId);
    }

    @PutMapping("assignMessageToPerson/{messageId}/{personId}")
    public void assignMessageToPerson(@PathVariable("messageId") Long messageId, @PathVariable("personId") Long personId) {
        this.messageService.assignMessageToPerson(messageId,personId);
    }
}

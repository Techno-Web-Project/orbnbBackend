package orbnb.backend.person;

import orbnb.backend.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
}

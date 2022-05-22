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


    @GetMapping("persons")
    public ResponseEntity<List<Person>> getPersons() {
        return new ResponseEntity<>(this.personService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping("getPersonById/{id}")
    public ResponseEntity<Optional<Person>> getPersonById(@PathVariable long id) {
        return new ResponseEntity<>(this.personService.getPersonById(id), HttpStatus.OK);
    }

    @GetMapping("getPersonByLogin/{login}")
    public ResponseEntity<Person> getPersonByLogin(@PathVariable String login) {
        return new ResponseEntity<>(this.personService.getPersonByLogin(login), HttpStatus.OK);
    }

    @PostMapping("newPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person newPerson) {
        return new ResponseEntity<>(personService.addPerson(newPerson), HttpStatus.CREATED);
    }

    @DeleteMapping("deletePerson/{id}")
    void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}

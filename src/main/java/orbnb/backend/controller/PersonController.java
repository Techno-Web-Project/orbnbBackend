package orbnb.backend.controller;

import orbnb.backend.model.Person;
import orbnb.backend.repository.PersonRepository;
import orbnb.backend.service.Person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("personApi/")
public class PersonController {

    @Autowired
    private PersonService personService;


    // http://localhost:8081/SpringMVC/personApi/persons
    @GetMapping("persons")
    public List<Person> getPersons(){
        return this.personService.retrieveAllPersons();
    }

    // http://localhost:8081/SpringMVC/personApi/getPersonById/{id}
    @GetMapping("getPersonById/{id}")
    public Person getPersonById(@PathVariable long id){
        return this.personService.retrievePersonById(id);
    }


    // http://localhost:8081/SpringMVC/personApi/getPersonByLogin/{login}
    @GetMapping("getPersonByLogin/{login}")
    public Person getPersonByLogin(@PathVariable String login){
        return this.personService.retrievePersonByLogin(login);
    }


    // http://localhost:8081/SpringMVC/personApi/newPerson
    @PostMapping("newPerson")
    Person addPerson(@RequestBody Person newPerson) {
        return personService.addPerson(newPerson);
    }


    // http://localhost:8081/SpringMVC/personApi/deletePerson/{id}
    @DeleteMapping("deletePerson/{id}")
    @ResponseBody
    void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}

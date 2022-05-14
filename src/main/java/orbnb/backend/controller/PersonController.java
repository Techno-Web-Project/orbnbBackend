package orbnb.backend.controller;

import orbnb.backend.model.Person;
import orbnb.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("personApi/")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("persons")
    public List<Person> getPersons(){
        return this.personRepository.findAll();
    }

    @GetMapping("getPerson/{id}")
    public Optional<Person> getPersonById(@PathVariable long id){
        return this.personRepository.findById(id);
    }
}

package orbnb.backend.controller;

import orbnb.backend.model.Person;
import orbnb.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("newPerson")
    Person addPerson(@RequestBody Person newPerson) {
        return personRepository.save(newPerson);
    }

    @PutMapping("replacePerson/{id}")
    Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {

        return personRepository.findById(id)
                .map(person -> {
                    person.setFirstName(newPerson.getFirstName());
                    person.setLastName(newPerson.getLastName());
                    person.setPhoneNumber(newPerson.getPhoneNumber());
                    person.setEmail(newPerson.getEmail());
                    person.setLogin(newPerson.getLogin());
                    person.setPassword(newPerson.getPassword());
                    person.setPicture(newPerson.getPicture());
                    person.setBirthDate(newPerson.getBirthDate());
                    return personRepository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return personRepository.save(newPerson);
                });
    }

    @GetMapping("deletePerson/{id}")
    void deleteEmployee(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}

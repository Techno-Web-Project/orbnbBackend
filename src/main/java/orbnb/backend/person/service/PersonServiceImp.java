package orbnb.backend.person.service;

import orbnb.backend.person.Person;
import orbnb.backend.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return this.personRepository.findAll();
    }

    @Override
    public Person addPerson(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        this.personRepository.deleteById(id);
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return this.personRepository.findById(id);
    }

    @Override
    public Person getPersonByLogin(String login) {
        return this.personRepository.findPersonByLogin(login);
    }

    @Override
    public Person updatePerson(Person person){
        return this.personRepository.save(person);
    }
}

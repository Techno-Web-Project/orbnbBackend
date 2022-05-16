package orbnb.backend.service.Person;

import orbnb.backend.model.Person;
import orbnb.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> retrieveAllPersons() {
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
    public Person retrievePersonById(Long id) {
        return this.personRepository.findPersonById(id);
    }

    @Override
    public Person retrievePersonByLogin(String login){
        return this.personRepository.findPersonByLogin(login);
    }
}

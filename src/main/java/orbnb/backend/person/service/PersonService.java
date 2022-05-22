package orbnb.backend.person.service;

import orbnb.backend.person.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAllPersons();

    Person addPerson(Person person);


    void deletePerson(Long id);

    Optional<Person> getPersonById(Long id);

    Person getPersonByLogin(String login);


}

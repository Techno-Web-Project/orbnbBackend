package orbnb.backend.service.Person;

import orbnb.backend.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> retrieveAllPersons();

    Person addPerson(Person person);


    void deletePerson(Long id) ;

    Person retrievePersonById(Long id) ;

    Person retrievePersonByLogin(String login) ;

}

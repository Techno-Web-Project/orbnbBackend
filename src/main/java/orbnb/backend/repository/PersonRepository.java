package orbnb.backend.repository;

import orbnb.backend.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();

    Person save(Person person);

    void delete(Person person);

    @Query("SELECT person FROM Person person WHERE person.id=:id")
    Person findPersonById(Long id);

    @Query("SELECT person FROM Person person WHERE person.login=:login")
    Person findPersonByLogin(String login);
}

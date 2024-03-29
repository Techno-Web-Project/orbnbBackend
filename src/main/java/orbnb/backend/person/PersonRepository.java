package orbnb.backend.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findPersonByLogin(String login);
    Person findPersonById(Long id);
}

package orbnb.backend.repository;

import orbnb.backend.model.Person_rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRateRepository extends CrudRepository<Person_rate, Long> {

    List<Person_rate> findAll();
}

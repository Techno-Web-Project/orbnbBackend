package orbnb.backend.repository;

import orbnb.backend.model.PersonRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRateRepository extends CrudRepository<PersonRate, Long> {

    List<PersonRate> findAll();

    PersonRate save(PersonRate personRate);

    void delete(PersonRate person_rate);

    @Query("select p from PersonRate p where p.id_person_rate=:id")
    PersonRate findPerson_rateById(@Param("id") Long id);
}

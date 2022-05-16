package orbnb.backend.repository;

import orbnb.backend.model.Housing;
import orbnb.backend.model.Person;
import org.springframework.data.jdbc.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HousingRepository extends CrudRepository<Housing, Long> {

    List<Housing> findAll();

    Housing save(Housing housing);

    void delete(Housing entity);

    @Query("select h from Housing h where h.id=:id")
    Housing findHousingById(@Param("id") Long id);


}

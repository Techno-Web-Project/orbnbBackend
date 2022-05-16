package orbnb.backend.repository;

import orbnb.backend.model.Service;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Long> {
    List<Service> findAll();

    Service save(Service service);

    void delete(Service service);

    @Query("SELECT service FROM Service service WHERE service.id=:id")
    Service findServiceById(Long id);
}

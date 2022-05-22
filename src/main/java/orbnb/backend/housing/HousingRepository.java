package orbnb.backend.housing;

import orbnb.backend.housing.Housing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HousingRepository extends JpaRepository<Housing, Long> {

    List<Housing> findHousingsByOwnerId(Long ownerId);

}
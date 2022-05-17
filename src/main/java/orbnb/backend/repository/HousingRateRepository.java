package orbnb.backend.repository;

import orbnb.backend.model.HousingRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HousingRateRepository extends CrudRepository<HousingRate, Long> {

    List<HousingRate> findAll();

    HousingRate save(HousingRate housingRate);

    void delete(HousingRate entity);

    @Query("select h from HousingRate h where h.id_housing_rate=:id")
    HousingRate findHousingRateById(@Param("id") Long id);
}

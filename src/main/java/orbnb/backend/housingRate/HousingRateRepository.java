package orbnb.backend.housingRate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingRateRepository extends JpaRepository<HousingRate, Long> {

    HousingRate findHousingRateByHousingRateId(Long Id);

}

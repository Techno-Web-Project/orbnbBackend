package orbnb.backend.housingRate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HousingRateRepository extends JpaRepository<HousingRate, Long> {

    HousingRate findHousingRateByHousingRateId(Long Id);

    List<HousingRate> findHousingRatesByNotedHousingId(Long notedHousingId);
}

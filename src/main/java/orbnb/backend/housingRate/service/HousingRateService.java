package orbnb.backend.housingRate.service;

import orbnb.backend.housingRate.HousingRate;

import java.util.List;
import java.util.Optional;

public interface HousingRateService {

    List<HousingRate> getAllHousingRate();

    HousingRate addHousingRate(HousingRate housingRate);

    void deleteHousingRate(Long housingRateId);

    Optional<HousingRate> getHousingRateById(Long housingRateId);

    void AssignHousingRateToHousing(Long idHousing, Long idHousingRate);
}

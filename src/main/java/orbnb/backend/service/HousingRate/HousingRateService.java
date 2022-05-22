package orbnb.backend.service.HousingRate;

import orbnb.backend.model.HousingRate;

import java.util.List;

public interface HousingRateService {

    List<HousingRate> retrieveAllHousingRate();

    HousingRate addHousingRate(HousingRate housingRate);

    void deleteHousingRate(Long id) ;

    HousingRate retrieveHousingRate(Long id) ;
}

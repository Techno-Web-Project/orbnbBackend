package orbnb.backend.service.HousingRate;

import orbnb.backend.model.Housing;
import orbnb.backend.model.HousingRate;

import java.util.List;

public interface HousingRateService {

    public List<HousingRate> retrieveAllHousingRate();

    public HousingRate addHousingRate(HousingRate housingRate);

    public void deleteHousingRate(Long id) ;

    public HousingRate retrieveHousingRate(Long id) ;
}

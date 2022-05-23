package orbnb.backend.housingRate.service;

import orbnb.backend.housing.Housing;
import orbnb.backend.housing.HousingRepository;
import orbnb.backend.housingRate.HousingRate;
import orbnb.backend.housingRate.HousingRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HousingRateServiceImpl implements HousingRateService {

    @Autowired
    private HousingRateRepository housingRateRepository;

    @Autowired
    private HousingRepository housingRepository;

    public List<HousingRate> getAllHousingRate() {
        return this.housingRateRepository.findAll();
    }

    public HousingRate addHousingRate(HousingRate housingRate) {
        return this.housingRateRepository.save(housingRate);
    }

    public void deleteHousingRate(Long housingRateId) {
        this.housingRateRepository.deleteById(housingRateId);
    }

    public Optional<HousingRate> getHousingRateById(Long housingRateId) {
        return this.housingRateRepository.findById(housingRateId);
    }

    public void AssignHousingRateToHousing(Long idHousing, Long idHousingRate){
        HousingRate housingRate = housingRateRepository.findHousingRateByHousingRateId(idHousingRate);
        Housing housing = housingRepository.findHousingsById(idHousing);
        housing.getHousingRates().add(housingRate);
        housingRate.setHousingId(idHousing);
        housingRepository.save(housing);
    }
}

package orbnb.backend.service.HousingRate;

import orbnb.backend.model.HousingRate;
import orbnb.backend.repository.HousingRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousingRateServiceImpl implements HousingRateService {

    @Autowired
    HousingRateRepository housingRateRepository;

    public List<HousingRate> retrieveAllHousingRate(){
        return housingRateRepository.findAll();
    }

    public HousingRate addHousingRate(HousingRate housingRate){
        housingRateRepository.save(housingRate);
        return housingRate;
    }

    public void deleteHousingRate(Long id){
        housingRateRepository.deleteById(id);
    }

    public HousingRate retrieveHousingRate(Long id){
        return housingRateRepository.findHousingRateById(id);
    }
}

package orbnb.backend.customService.service;

import orbnb.backend.customService.CustomService;
import orbnb.backend.customService.CustomServiceRepository;
import orbnb.backend.housing.Housing;
import orbnb.backend.housing.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomServiceServiceImpl implements CustomServiceService{

    @Autowired
    private CustomServiceRepository customServiceRepository;

    @Autowired
    private HousingRepository housingRepository;

    @Override
    public List<CustomService> getCustomServicesByLinkedHousingId(Long linkedHousingId) {
        return this.customServiceRepository.getCustomServicesByIdLinkedHousing(linkedHousingId);
    }

    @Override
    public CustomService addCustomService(CustomService customService) {
        return this.customServiceRepository.save(customService);
    }

    @Override
    public void deleteCustomService(Long customServiceId) {
        this.customServiceRepository.deleteById(customServiceId);
    }

    @Override
    public void assignCustomServiceToHousing(Long housingId, Long customServiceId) {
        Housing housing = this.housingRepository.findHousingsById(housingId);
        CustomService customService = this.customServiceRepository.getCustomServiceByCustomServiceId(customServiceId);
        housing.getCustomServices().add(customService);
        customService.setIdLinkedHousing(housingId);
        this.housingRepository.save(housing);
    }

}

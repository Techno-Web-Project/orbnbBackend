package orbnb.backend.customService.service;


import orbnb.backend.customService.CustomService;

import java.util.List;
import java.util.Optional;

public interface CustomServiceService {
    List<CustomService> getCustomServicesByLinkedHousingId(Long linkedHousingId);

    CustomService addCustomService(CustomService customService);

    void deleteCustomService(Long customServiceId);

    void assignCustomServiceToHousing(Long housingId, Long customServiceId);

}

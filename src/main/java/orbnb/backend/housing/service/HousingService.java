package orbnb.backend.housing.service;

import orbnb.backend.housing.Housing;

import java.util.List;
import java.util.Optional;

public interface HousingService {

    List<Housing> getAllHousings();

    Housing addHousing(Housing housing);

    void deleteHousing(Long housingId);

    Optional<Housing> getHousingById(Long housingId);

    void assignHousingToPerson(Long personId, Long housingId);

}
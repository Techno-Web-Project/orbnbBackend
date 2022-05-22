package orbnb.backend.housing.service;

import orbnb.backend.housing.Housing;

import orbnb.backend.housing.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HousingServiceImpl implements HousingService {

    @Autowired
    private HousingRepository housingRepository;

    @Override
    public List<Housing> getAllHousings() {
        return this.housingRepository.findAll();
    }

    @Override
    public Housing addHousing(Housing housing) {
        return this.housingRepository.save(housing);
    }

    @Override
    public void deleteHousing(Long housingId) {
        this.housingRepository.deleteById(housingId);
    }

    @Override
    public Optional<Housing> getHousingById(Long housingId) {
        return this.housingRepository.findById(housingId);
    }

}

package orbnb.backend.customConstraint.service;

import orbnb.backend.customConstraint.CustomConstraint;
import orbnb.backend.customConstraint.CustomConstraintRepository;
import orbnb.backend.housing.Housing;
import orbnb.backend.housing.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomConstraintServiceImpl implements CustomConstraintService{

    @Autowired
    private CustomConstraintRepository customConstraintRepository;

    @Autowired
    private HousingRepository housingRepository;

    @Override
    public List<CustomConstraint> getCustomConstraintByLinkedHousingId(Long linkedHousingId) {
        return this.customConstraintRepository.getCustomConstraintsByLinkedHousingId(linkedHousingId);
    }

    @Override
    public CustomConstraint addCustomConstraint(CustomConstraint customConstraint) {
        return this.customConstraintRepository.save(customConstraint);
    }

    @Override
    public void deleteCustomConstraint(Long customConstraintId) {
        this.customConstraintRepository.deleteById(customConstraintId);
    }

    @Override
    public void assignCustomConstraintToHousing(Long housingId, Long customConstraintId) {
        Housing housing = this.housingRepository.findHousingsById(housingId);
        CustomConstraint customConstraint = this.customConstraintRepository.getCustomConstraintByCustomConstraintId(customConstraintId);
        housing.getCustomConstraints().add(customConstraint);
        customConstraint.setLinkedHousingId(housingId);
        this.housingRepository.save(housing);
    }
}

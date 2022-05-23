package orbnb.backend.customConstraint.service;

import orbnb.backend.customConstraint.CustomConstraint;

import java.util.List;

public interface CustomConstraintService {

    List<CustomConstraint> getCustomConstraintByLinkedHousingId(Long linkedHousingId);

    CustomConstraint addCustomConstraint(CustomConstraint customConstraint);

    void deleteCustomConstraint(Long customConstraintId);

    void assignCustomConstraintToHousing(Long housingId, Long customConstraintId);
}

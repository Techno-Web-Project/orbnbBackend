package orbnb.backend.constraint.service;

import orbnb.backend.constraint.Constraints;
import orbnb.backend.constraint.ConstraintsRepository;
import orbnb.backend.housing.Housing;
import orbnb.backend.housing.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstraintsServiceImpl implements ConstraintsService {

    @Autowired
    private ConstraintsRepository constraintsRepository;

    @Autowired
    private HousingRepository housingRepository;

    @Override
    public List<Constraints> getAllServices() {
        return this.constraintsRepository.findAll();
    }

    @Override
    public Constraints addConstraint(Constraints constraints) {
        return this.constraintsRepository.save(constraints);
    }

    @Override
    public void deleteConstraint(Long constraintId) {
        this.constraintsRepository.deleteById(constraintId);
    }

    @Override
    public Optional<Constraints> getConstraintById(Long constraintId) {
        return this.constraintsRepository.findById(constraintId);
    }

    @Override
    public void AssignConstraintToHousing(Long HousingId, Long ConstraintId){
        Housing housing = housingRepository.findHousingsById(HousingId);
        Constraints constraints = constraintsRepository.findConstraintsByConstraintsId(ConstraintId);
        housing.getLinkedConstraints().add(constraints);
        housingRepository.save(housing);
    }
}

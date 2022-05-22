package orbnb.backend.constraint.service;

import orbnb.backend.constraint.Constraints;
import orbnb.backend.constraint.ConstraintsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstraintsServiceImpl implements ConstraintsService {

    @Autowired
    private ConstraintsRepository constraintsRepository;

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
}

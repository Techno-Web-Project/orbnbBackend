package orbnb.backend.constraint.service;


import orbnb.backend.constraint.Constraints;

import java.util.List;
import java.util.Optional;

public interface ConstraintsService {
    List<Constraints> getAllServices();

    Constraints addConstraint(Constraints constraints);

    void deleteConstraint(Long constraintId);

    Optional<Constraints> getConstraintById(Long constraintId);
}

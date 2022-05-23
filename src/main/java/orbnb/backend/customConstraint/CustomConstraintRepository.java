package orbnb.backend.customConstraint;

import orbnb.backend.customService.CustomService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomConstraintRepository extends JpaRepository<CustomConstraint, Long> {
    List<CustomConstraint> getCustomConstraintsByLinkedHousingId(Long linkedHousingId);

    CustomConstraint getCustomConstraintByCustomConstraintId(Long customConstraintId);
}

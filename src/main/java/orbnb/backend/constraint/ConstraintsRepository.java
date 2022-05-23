package orbnb.backend.constraint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstraintsRepository extends JpaRepository<Constraints, Long> {

    Constraints findConstraintsByConstraintsId(Long Id);
}

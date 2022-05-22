package orbnb.backend.personRate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRateRepository extends JpaRepository<PersonRate, Long> {
    PersonRate findPersonRateByPersonRateId(Long id);
}

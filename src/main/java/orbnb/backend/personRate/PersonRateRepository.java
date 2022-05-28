package orbnb.backend.personRate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRateRepository extends JpaRepository<PersonRate, Long> {
    PersonRate findPersonRateByPersonRateId(Long id);

    List<PersonRate> findPersonRatesByNotedPersonId(Long notedPersonId);
}

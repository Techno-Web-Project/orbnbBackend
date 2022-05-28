package orbnb.backend.personRate.service;


import orbnb.backend.personRate.PersonRate;

import java.util.List;
import java.util.Optional;

public interface PersonRateService {

    List<PersonRate> getAllPersonRate();

    PersonRate addPersonRate(PersonRate personRate);

    void deletePersonRate(Long personRateId);

    Optional<PersonRate> getPersonRateById(Long personRateId);

    void assignRateToPerson(Long idPersonrate, Long idPerson);

    Double getPersonAverageNote(Long notedPersonId);

}


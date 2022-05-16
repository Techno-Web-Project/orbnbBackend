package orbnb.backend.service.Person_rate;


import orbnb.backend.model.PersonRate;

import java.util.List;

public interface PersonRateService {

    public List<PersonRate> retrieveAllPersonRate();

    public PersonRate addPersonRate(PersonRate personRate);

    public void deletePersonRate(Long id);

    public PersonRate retrievePersonRate(Long id);
}

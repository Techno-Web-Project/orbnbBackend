package orbnb.backend.service.Person_rate;

import orbnb.backend.model.PersonRate;
import orbnb.backend.repository.PersonRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRateServiceImpl {

    @Autowired
    PersonRateRepository personRateRepository;

    public List<PersonRate> retrieveAllPersonRate(){
        return personRateRepository.findAll();
    }

    public PersonRate addPersonRate(PersonRate personRate){
        personRateRepository.save(personRate);
        return personRate;
    }

    public void deleteHousing(Long id){
        personRateRepository.deleteById(id);
    }

    public PersonRate retrievePersonRate(Long id){
        return personRateRepository.findPerson_rateById(id);
    }
}

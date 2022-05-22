package orbnb.backend.personRate.service;

import orbnb.backend.personRate.PersonRate;
import orbnb.backend.personRate.PersonRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonRateServiceImpl implements PersonRateService {

    @Autowired
    private PersonRateRepository personRateRepository;

    @Override
    public List<PersonRate> getAllPersonRate(){
        return this.personRateRepository.findAll();
    }

    @Override
    public PersonRate addPersonRate(PersonRate personRate){
        return this.personRateRepository.save(personRate);
    }

    @Override
    public void deletePersonRate(Long personRateId){
        this.personRateRepository.deleteById(personRateId);
    }

    @Override
    public Optional<PersonRate> getPersonRateById(Long personRateId){
        return this.personRateRepository.findById(personRateId);
    }
}

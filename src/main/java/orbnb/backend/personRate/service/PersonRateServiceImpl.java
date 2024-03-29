package orbnb.backend.personRate.service;

import orbnb.backend.person.Person;
import orbnb.backend.person.PersonRepository;
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

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<PersonRate> getAllPersonRate() {
        return this.personRateRepository.findAll();
    }

    @Override
    public PersonRate addPersonRate(PersonRate personRate) {
        return this.personRateRepository.save(personRate);
    }

    @Override
    public void deletePersonRate(Long personRateId) {
        this.personRateRepository.deleteById(personRateId);
    }

    @Override
    public Optional<PersonRate> getPersonRateById(Long personRateId) {
        return this.personRateRepository.findById(personRateId);
    }

    @Override
    public void assignRateToPerson(Long idPersonRate, Long idPerson) {
        PersonRate personRate = this.personRateRepository.findPersonRateByPersonRateId(idPersonRate);
        Person person = this.personRepository.findPersonById(idPerson);
        person.getPersonRates().add(personRate);
        personRate.setNotedPersonId(idPerson);
        personRepository.save(person);

    }

    @Override
    public Double getPersonAverageNote(Long notedPersonId) {
        List<PersonRate> personRatesList = this.personRateRepository.findPersonRatesByNotedPersonId(notedPersonId);
        Double averageNote = 0.0;
        for (PersonRate personRate : personRatesList) {
            averageNote += personRate.getRate();
        }
        averageNote = averageNote / personRatesList.size();
        return averageNote;
    }
}

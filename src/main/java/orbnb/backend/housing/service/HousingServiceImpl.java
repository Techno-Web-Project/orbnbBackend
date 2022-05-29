package orbnb.backend.housing.service;

import orbnb.backend.booking.BookingRepository;
import orbnb.backend.housing.Housing;

import orbnb.backend.housing.HousingRepository;
import orbnb.backend.person.Person;
import orbnb.backend.person.PersonRepository;
import orbnb.backend.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HousingServiceImpl implements HousingService {

    @Autowired
    private HousingRepository housingRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Housing> getAllHousings() {
        return this.housingRepository.findAll();
    }

    @Override
    public Housing addHousing(Housing housing) {
        return this.housingRepository.save(housing);
    }

    @Override
    public void deleteHousing(Long housingId) {
        this.housingRepository.deleteById(housingId);
    }

    @Override
    public Optional<Housing> getHousingById(Long housingId) {
        return this.housingRepository.findById(housingId);
    }

    @Override
    public void assignHousingToPerson(Long personId, Long housingId) {
        Person person = this.personRepository.findPersonById(personId);
        Housing housing = this.housingRepository.findHousingsById(housingId);
        person.getHousingsOwned().add(housing);
        housing.setPersonId(personId);
        this.personRepository.save(person);
    }

    @Override
    public boolean isHousingAvailable(Long housingId, Date startingDate, Date endingDate) {
        List<Long> bookingList = this.bookingRepository.bookingFromDateToDateByHousingId(housingId, startingDate, endingDate);
        return bookingList.size() == 0;
    }

     @Override
     public Housing updateHousing(Housing housing){
        return this.housingRepository.save(housing);
     }


}

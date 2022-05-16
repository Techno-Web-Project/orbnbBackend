package orbnb.backend.service.Housing;

import orbnb.backend.model.Housing;

import orbnb.backend.repository.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousingServiceImpl implements HousingService{

    @Autowired
    HousingRepository HousingRepository;

    public List<Housing> retrieveAllHousings() { return HousingRepository.findAll();}

    public Housing addHousing(Housing h){
        HousingRepository.save(h);
        return h;
    }

    public void deleteHousing(Long id) { HousingRepository.deleteById(id);}

    public Housing retrieveHousing(Long id) {return HousingRepository.findHousingById(id);}

}

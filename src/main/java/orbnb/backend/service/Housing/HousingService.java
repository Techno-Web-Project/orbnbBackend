package orbnb.backend.service.Housing;

import orbnb.backend.model.Housing;

import java.util.List;

public interface HousingService {

    public List<Housing> retrieveAllHousings();

    public Housing addHousing(Housing h);


    public void deleteHousing(Long id) ;

    public Housing retrieveHousing(Long id) ;

}

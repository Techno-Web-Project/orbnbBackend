package orbnb.backend.controller;

import orbnb.backend.model.Housing;
import orbnb.backend.service.Housing.HousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/housing")
public class HousingController {
    @Autowired
    HousingService housingService;

    // http://localhost:8081/SpringMVC/housing/retrieve-all-housings

    @GetMapping("/retrieve-all-housings")
    @ResponseBody
    public List<Housing> getHousings() {
        List<Housing> listHousings = housingService.retrieveAllHousings();
        return listHousings;
    }

    // http://localhost:8081/SpringMVC/housing/retrieve-housing/{housing-id}

    @GetMapping("retrieve-housing/{housing-id}")
    @ResponseBody
    public Housing getHousing(@PathVariable("housing-id") Long housingId) {
        return housingService.retrieveHousing(housingId);
    }


    // http://localhost:8081/SpringMVC/housing/add-housing

    @PostMapping("/add-housing")
    @ResponseBody
    public Housing addHousing (@RequestBody Housing h) {
        Housing housing = housingService.addHousing(h);
        return housing;
    }

    // http://localhost:8081/SpringMVC/housing/remove-housing/{housing-id}
    @DeleteMapping("/remove-housing/{housing-id}")
    @ResponseBody
    public void removeHousing(@PathVariable("housing-id") Long housingId) {
        housingService.deleteHousing(housingId);}
}
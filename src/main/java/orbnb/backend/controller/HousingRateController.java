package orbnb.backend.controller;

import orbnb.backend.model.HousingRate;
import orbnb.backend.service.HousingRate.HousingRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/housingRate")
public class HousingRateController {

    @Autowired
    HousingRateService housingRateService;


    // http://localhost:8081/SpringMVC/housingRate/retrieve-all-housingRate

    @GetMapping("/retrieve-all-housingRate")
    @ResponseBody
    public List<HousingRate> getHousingRate() {
        List<HousingRate> listHousingRate = housingRateService.retrieveAllHousingRate();
        return listHousingRate;
    }

    // http://localhost:8081/SpringMVC/housingRate/retrieve-housingRate/{id-HousingRate}

    @GetMapping("retrieve-housingRate/{id-HousingRate}")
    @ResponseBody
    public HousingRate getHousingRate(@PathVariable("id-HousingRate") Long housingRateId) {
        return housingRateService.retrieveHousingRate(housingRateId);
    }

    // http://localhost:8081/SpringMVC/housingRate/add-housingRate

    @PostMapping("/add-housingRate")
    @ResponseBody
    public HousingRate addHousingRate (@RequestBody HousingRate h) {
        HousingRate housingRate = housingRateService.addHousingRate(h);
        return housingRate;
    }

    // http://localhost:8081/SpringMVC/housingRate/remove-housingRate/{housing-id}

    @DeleteMapping("/remove-housingRate/{housing-id}")
    @ResponseBody
    public void removeHousingRate(@PathVariable("housing-id") Long housingId) {
        housingRateService.deleteHousingRate(housingId);
    }

}

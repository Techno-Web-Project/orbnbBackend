package orbnb.backend.housingRate;

import orbnb.backend.housingRate.service.HousingRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/housingRateApi")
public class HousingRateController {

    @Autowired
    private HousingRateService housingRateService;

    @GetMapping("/getAllHousingRates")
    public ResponseEntity<List<HousingRate>> getHousingRate() {
        return new ResponseEntity<>(this.housingRateService.getAllHousingRate(), HttpStatus.OK);
    }

    @GetMapping("getHousingRateById/{housingRateId}")
    public ResponseEntity<Optional<HousingRate>> getHousingRate(@PathVariable("housingRateId") Long housingRateId) {
        return new ResponseEntity<>(this.housingRateService.getHousingRateById(housingRateId), HttpStatus.OK);
    }

    @PostMapping("/addHousingRate")
    public ResponseEntity<HousingRate> addHousingRate(@RequestBody HousingRate housingRate) {
        return new ResponseEntity<>(this.housingRateService.addHousingRate(housingRate), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteHousingRate/{housingRateId}")
    public void removeHousingRate(@PathVariable("housingRateId") Long housingRateId) {
        this.housingRateService.deleteHousingRate(housingRateId);
    }

}

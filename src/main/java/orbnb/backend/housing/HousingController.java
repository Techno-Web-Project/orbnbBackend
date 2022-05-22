package orbnb.backend.housing;

import orbnb.backend.housing.service.HousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/housingApi")
public class HousingController {
    @Autowired
    private HousingService housingService;

    @GetMapping("/getAllHousings")
    @ResponseBody
    public ResponseEntity<List<Housing>> getHousings() {
        return new ResponseEntity<>(this.housingService.getAllHousings(), HttpStatus.OK);
    }

    @GetMapping("/getHousingById/{housingId}")
    public ResponseEntity<Optional<Housing>> getHousing(@PathVariable("housingId") Long housingId) {
        return new ResponseEntity<>(this.housingService.getHousingById(housingId), HttpStatus.OK);
    }

    @PostMapping("/addHousing")
    public ResponseEntity<Housing> addHousing(@RequestBody Housing housing) {
        return new ResponseEntity<>(this.housingService.addHousing(housing), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteHousing/{housingId}")
    public void removeHousing(@PathVariable("housingId") Long housingId) {
        this.housingService.deleteHousing(housingId);
    }

}
package orbnb.backend.housing;

import orbnb.backend.constraint.service.ConstraintsService;
import orbnb.backend.housing.service.HousingService;
import orbnb.backend.housingRate.service.HousingRateService;
import orbnb.backend.picture.service.PictureService;
import orbnb.backend.service.service.ServiceService;
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

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ConstraintsService constraintsService;

    @Autowired
    private HousingRateService housingRateService;
    private PictureService pictureService;

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

    @PutMapping("/assignservice/{housingId}/{serviceId}")
    public void assignServiceToHousing(@PathVariable("housingId") Long HousingId, @PathVariable("serviceId") Long ServiceId){
        this.serviceService.assignServiceToHousing(HousingId,ServiceId);
    }

    @PutMapping("/assignconstraint/{housingId}/{constraintId}")
    public void assignConstraintToHousing(@PathVariable("housingId") Long HousingId, @PathVariable("constraintId") Long ConstraintId){
        this.constraintsService.AssignConstraintToHousing(HousingId,ConstraintId);
    }

    @PutMapping("/assignhousingrate/{housingId}/{housingrateid}")
    public void assignHousingRateToHousing(@PathVariable("housingId") Long HousingId, @PathVariable("housingrateid")Long HousingrateId){
        this.housingRateService.AssignHousingRateToHousing(HousingId,HousingrateId);
    @PutMapping("/assignPictureToHousing/{housingId}/{pictureId}")
    public void assignPictureToHousing(@PathVariable("housingId") Long housingId, @PathVariable("pictureId") Long pictureId){
        this.pictureService.assignPictureToHousing(housingId, pictureId);
    }

}
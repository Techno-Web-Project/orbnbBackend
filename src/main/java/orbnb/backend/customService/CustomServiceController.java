package orbnb.backend.customService;

import orbnb.backend.customService.service.CustomServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customServiceApi")
public class CustomServiceController {

    @Autowired
    private CustomServiceService customServiceService;

    @PostMapping("/addCustomService")
    public ResponseEntity<CustomService> addCustomService(@RequestBody CustomService customService){
        return new ResponseEntity<>(this.customServiceService.addCustomService(customService), HttpStatus.CREATED);
    }

    @GetMapping("/getCustomServicesByLinkedHousingId/{linkedHousingId}")
    public ResponseEntity<List<CustomService>> getCustomServicesByLinkedHousingId(@PathVariable("linkedHousingId") Long linkedHousingId){
        return new ResponseEntity<>(this.customServiceService.getCustomServicesByLinkedHousingId(linkedHousingId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomService/{customServiceId}")
    public void removeCustomService(@PathVariable("customServiceId") Long customServiceId){
        this.customServiceService.deleteCustomService(customServiceId);
    }
}

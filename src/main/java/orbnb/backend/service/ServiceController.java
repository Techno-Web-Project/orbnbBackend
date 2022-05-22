package orbnb.backend.service;

import orbnb.backend.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/serviceApi")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/addService")
    public ResponseEntity<Service> addService(@RequestBody Service service){
        return new ResponseEntity<>(this.serviceService.addService(service), HttpStatus.CREATED);
    }

    @GetMapping("/getAllServices")
    public ResponseEntity<List<Service>> getServices(){
        return new ResponseEntity<>(this.serviceService.getAllServices(), HttpStatus.OK);
    }

    @GetMapping("/getServiceById/{serviceId}")
    public ResponseEntity<Optional<Service>> getService(@PathVariable("serviceId") Long serviceId){
        return new ResponseEntity<>(this.serviceService.getServiceById(serviceId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteService/{serviceId}")
    public void removeService(@PathVariable("serviceId") Long serviceId){
        this.serviceService.deleteService(serviceId);
    }
}

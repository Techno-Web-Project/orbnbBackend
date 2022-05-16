package orbnb.backend.controller;

import orbnb.backend.model.Service;
import orbnb.backend.service.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("serviceApi/")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    //http://localhost:8081/SpringMVC/serviceApi/services
    @GetMapping("services")
    public List<Service> getServices(){
        return this.serviceService.retrieveAllServices();
    }

    //http://localhost:8081/SpringMVC/serviceApi/getServiceById/{id}
    @GetMapping("getServiceById/{id}")
    public Service getServiceById(@PathVariable long id){
        return this.serviceService.retrieveServiceById(id);
    }

    //http://localhost:8081/SpringMVC/serviceApi/newService
    @PostMapping("newService")
    Service addService(@RequestBody Service service){
        return this.serviceService.addService(service);
    }

    //http://localhost:8081/SpringMVC/serviceApi/deleteService/{id}
    @DeleteMapping("deleteService/{id}")
    @ResponseBody
    void deleteService(@PathVariable Long id){
        this.serviceService.deleteService(id);
    }
}

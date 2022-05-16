package orbnb.backend.controller;

import orbnb.backend.model.PersonRate;
import orbnb.backend.service.Person_rate.PersonRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/personRate")
public class PersonRateController {

    @Autowired
    PersonRateService personRateService;


    //http://localhost:8081/SpringMVC/personRate/retrieve-all-personRate

    @GetMapping("/retrieve-all-personRate")
    @ResponseBody
    public List<PersonRate> getPersonRate(){
        List<PersonRate> listPersonRate = personRateService.retrieveAllPersonRate();
        return listPersonRate;
    }

    //http://localhost:8081/SpringMVC/personRate/retrieve-all-personRate/{id_personRate}

    @GetMapping("/retrieve-all-personRate/{id_personRate}")
    @ResponseBody
    public PersonRate getPersonRate(@PathVariable("id_personRate") Long id){
        return personRateService.retrievePersonRate(id);
    }


    //http://localhost:8081/SpringMVC/personRate/add-personRate

    @PostMapping("/add-personRate")
    @ResponseBody
    public PersonRate addPersonRate(@RequestBody PersonRate p){
        PersonRate personRate = personRateService.addPersonRate(p);
        return personRate;
    }


    //http://localhost:8081/SpringMVC/personRate/removePersonRate/{id-personRate}

    @DeleteMapping("/removePersonRate/{id-personRate}")
    public void removePersonRate(@PathVariable("id-personRate") Long id){
        personRateService.deletePersonRate(id);
    }
}

package orbnb.backend.controller;

import orbnb.backend.model.Housing;
import orbnb.backend.repository.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("housingApi/")
public class HousingController {

    @Autowired
    private HousingRepository housingRepository;

    @GetMapping("housings")
    public List<Housing> getHousings(){
        return this.housingRepository.findAll();
    }

    @GetMapping("getHousing/{id}")
    public Optional<Housing> getHousingById(@PathVariable long id){
        return this.housingRepository.findById(id);
    }

    @PostMapping("newHousing")
    Housing addHousing(@RequestBody Housing newHousing){
        return this.housingRepository.save(newHousing);
    }

    @GetMapping("deleteHousing/{id}")
    void deleteHousing(@PathVariable long id){
        this.housingRepository.deleteById(id);
    }
}

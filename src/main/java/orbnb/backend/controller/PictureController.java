package orbnb.backend.controller;

import orbnb.backend.model.Picture;
import orbnb.backend.service.Picture.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    PictureService pictureService;


    // http://localhost:8081/SpringMVC/picture/retrieve-all-pictures

    @GetMapping("/retrieve-all-pictures")
    @ResponseBody
    public List<Picture> getPicture(){
        List<Picture> listPicture = pictureService.retrieveAllPictures();
        return listPicture;
    }

    // http://localhost:8081/SpringMVC/picture/retrieve-picture/{picture-id}

    @GetMapping("/retrieve-picture/{picture-id}")
    @ResponseBody
    public Picture getPicture(@PathVariable("picture-id") Long pictureId){
        return pictureService.retrievePicture(pictureId);
    }


    // http://localhost:8081/SpringMVC/picture/add-picture

    @PostMapping("/add-picture")
    @ResponseBody
    public Picture addPicture(@RequestBody Picture p){
        Picture picture = pictureService.addPicture(p);
        return picture;
    }

    // http://localhost:8081/SpringMVC/picture/remove-picture/{picture-id}

    @DeleteMapping("/remove-picture/{picture-id}")
    @ResponseBody
    public void removePicture(@PathVariable("picture-id") Long pictureId){
        pictureService.deletePicture(pictureId);
    }
}

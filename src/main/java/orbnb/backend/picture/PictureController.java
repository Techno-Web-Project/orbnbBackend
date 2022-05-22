package orbnb.backend.picture;

import orbnb.backend.picture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pictureApi")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/getAllPictures")
    public ResponseEntity<List<Picture>> getPicture() {
        return new ResponseEntity<>(this.pictureService.getAllPictures(), HttpStatus.OK);
    }

    @GetMapping("/getPictureById/{pictureId}")
    public ResponseEntity<Optional<Picture>> getPicture(@PathVariable("pictureId") Long pictureId) {
        return new ResponseEntity<>(this.pictureService.getPictureById(pictureId), HttpStatus.OK);
    }

    @PostMapping("/addPicture")
    public ResponseEntity<Picture> addPicture(@RequestBody Picture picture) {
        return new ResponseEntity<>(this.pictureService.addPicture(picture), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePicture/{pictureId}")
    public void removePicture(@PathVariable("pictureId") Long pictureId) {
        this.pictureService.deletePicture(pictureId);
    }
}

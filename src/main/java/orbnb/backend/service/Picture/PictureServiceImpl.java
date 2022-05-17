package orbnb.backend.service.Picture;

import orbnb.backend.model.Picture;
import orbnb.backend.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService{

    @Autowired
    PictureRepository pictureRepository;

    public List<Picture> retrieveAllPictures(){
        return pictureRepository.findAll();
    }

    public Picture addPicture(Picture picture){
        pictureRepository.save(picture);
        return picture;
    }

    public void deletePicture(Long id){
        pictureRepository.deleteById(id);
    }

    public Picture retrievePicture(Long id){
        return pictureRepository.findPictureById(id);
    }
}

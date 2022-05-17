package orbnb.backend.service.Picture;

import orbnb.backend.model.Housing;
import orbnb.backend.model.Picture;

import java.util.List;

public interface PictureService {

    public List<Picture> retrieveAllPictures();

    public Picture addPicture(Picture picture);

    public void deletePicture(Long id) ;

    public Picture retrievePicture(Long id) ;
}

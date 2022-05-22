package orbnb.backend.service.Picture;

import orbnb.backend.model.Picture;

import java.util.List;

public interface PictureService {

    List<Picture> retrieveAllPictures();

    Picture addPicture(Picture picture);

    void deletePicture(Long id) ;

    Picture retrievePicture(Long id) ;
}

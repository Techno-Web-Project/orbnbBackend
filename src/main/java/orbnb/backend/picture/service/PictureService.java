package orbnb.backend.picture.service;

import orbnb.backend.picture.Picture;

import java.util.List;
import java.util.Optional;

public interface PictureService {

    List<Picture> getAllPictures();

    Picture addPicture(Picture picture);

    void deletePicture(Long pictureId);

    Optional<Picture> getPictureById(Long pictureId);

    void assignPictureToHousing(Long housingId, Long pictureId);
}

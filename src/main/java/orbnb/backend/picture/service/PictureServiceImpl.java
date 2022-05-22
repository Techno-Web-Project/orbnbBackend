package orbnb.backend.picture.service;

import orbnb.backend.picture.Picture;
import orbnb.backend.picture.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureRepository pictureRepository;

    @Override
    public List<Picture> getAllPictures() {
        return this.pictureRepository.findAll();
    }

    @Override
    public Picture addPicture(Picture picture) {
        return this.pictureRepository.save(picture);
    }

    @Override
    public void deletePicture(Long pictureId) {
        this.pictureRepository.deleteById(pictureId);
    }

    @Override
    public Optional<Picture> getPictureById(Long pictureId) {
        return this.pictureRepository.findById(pictureId);
    }
}

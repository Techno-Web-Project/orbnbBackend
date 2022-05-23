package orbnb.backend.picture.service;

import orbnb.backend.housing.Housing;
import orbnb.backend.housing.HousingRepository;
import orbnb.backend.picture.Picture;
import orbnb.backend.picture.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private HousingRepository housingRepository;

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

    @Override
    public void assignPictureToHousing(Long housingId, Long pictureId) {
        Housing housing = this.housingRepository.findHousingsById(housingId);
        Picture picture = this.pictureRepository.getPictureByPictureId(pictureId);
        housing.getHousingPictures().add(picture);
        picture.setHousingId(housingId);
        this.housingRepository.save(housing);
    }
}

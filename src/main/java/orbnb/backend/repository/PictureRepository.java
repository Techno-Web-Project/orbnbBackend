package orbnb.backend.repository;

import orbnb.backend.model.Picture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {

    List<Picture> findAll();

    Picture save(Picture picture);

    void delete(Picture picture);

    @Query("select p from Picture p where p.id_picture=:id")
    Picture findPictureById(@Param("id") Long id);

}

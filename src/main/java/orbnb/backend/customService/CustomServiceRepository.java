package orbnb.backend.customService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomServiceRepository extends JpaRepository<CustomService, Long> {
    List<CustomService> getCustomServicesByIdLinkedHousing(Long idLinkedHousing);

    CustomService getCustomServiceByCustomServiceId(Long customServiceId);
}

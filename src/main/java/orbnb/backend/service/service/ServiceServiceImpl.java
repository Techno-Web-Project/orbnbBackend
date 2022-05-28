package orbnb.backend.service.service;

import orbnb.backend.housing.Housing;
import orbnb.backend.housing.HousingRepository;
import orbnb.backend.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService{

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private HousingRepository housingRepository;

    @Override
    public List<orbnb.backend.service.Service> getAllServices() {
        return this.serviceRepository.findAll();
    }

    @Override
    public orbnb.backend.service.Service addService(orbnb.backend.service.Service service) {
        return this.serviceRepository.save(service);
    }

    @Override
    public void deleteService(Long serviceId) {
        this.serviceRepository.deleteById(serviceId);
    }

    @Override
    public Optional<orbnb.backend.service.Service> getServiceById(Long serviceId) {
        return this.serviceRepository.findById(serviceId);
    }

    @Override
    public void assignServiceToHousing(Long HousingId, Long ServiceId){
        Housing housing = housingRepository.findHousingsById(HousingId);
        orbnb.backend.service.Service service = serviceRepository.findServiceByServiceId(ServiceId);
        housing.getLinkedServices().add(service);
        housingRepository.save(housing);

    }
}

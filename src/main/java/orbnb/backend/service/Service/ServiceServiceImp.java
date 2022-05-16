package orbnb.backend.service.Service;

import orbnb.backend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImp implements ServiceService{

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<orbnb.backend.model.Service> retrieveAllServices() {
        return this.serviceRepository.findAll();
    }

    @Override
    public orbnb.backend.model.Service addService(orbnb.backend.model.Service service) {
        return this.serviceRepository.save(service);
    }

    @Override
    public void deleteService(Long id) {
        this.serviceRepository.deleteById(id);
    }

    @Override
    public orbnb.backend.model.Service retrieveServiceById(Long id) {
        return this.serviceRepository.findServiceById(id);
    }
}

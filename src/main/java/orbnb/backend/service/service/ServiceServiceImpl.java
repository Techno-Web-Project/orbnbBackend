package orbnb.backend.service.service;

import orbnb.backend.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService{

    @Autowired
    private ServiceRepository serviceRepository;

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
}

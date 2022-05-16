package orbnb.backend.service.Service;

import orbnb.backend.model.Service;

import java.util.List;

public interface ServiceService {
    List<Service> retrieveAllServices();

    Service addService(Service service);

    void deleteService(Long id);

    Service retrieveServiceById(Long id);
}

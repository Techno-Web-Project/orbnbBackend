package orbnb.backend.service.service;


import orbnb.backend.service.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceService {

    List<Service> getAllServices();

    Service addService(Service service);


    void deleteService(Long serviceId) ;

    Optional<Service> getServiceById(Long serviceId) ;
}

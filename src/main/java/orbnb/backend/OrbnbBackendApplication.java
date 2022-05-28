package orbnb.backend;


import orbnb.backend.constraint.Constraints;
import orbnb.backend.constraint.ConstraintsRepository;
import orbnb.backend.service.Service;
import orbnb.backend.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class OrbnbBackendApplication implements CommandLineRunner {

    @Autowired
    private ConstraintsRepository constraintsRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrbnbBackendApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        if (constraintsRepository.findAll().size() == 0) {
            constraintsRepository.save(new Constraints("Interdiction de fumer", "logo.jpg"));
            constraintsRepository.save(new Constraints("Animaux interdits", "logo.jpg"));
            constraintsRepository.save(new Constraints("Enfants interdits", "logo.jpg"));
        }
        if (serviceRepository.findAll().size() == 0) {
            serviceRepository.save(new Service("Arroser les plantes", "logo.jpg"));
            serviceRepository.save(new Service("Nourrir les animaux", "logo.jpg"));
            serviceRepository.save(new Service("Faire le ménage", "logo.jpg"));
        }
    }
}





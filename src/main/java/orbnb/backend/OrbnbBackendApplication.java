package orbnb.backend;

import orbnb.backend.model.Housing;
import orbnb.backend.model.Person;
import orbnb.backend.model.enumeration.HousingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class OrbnbBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrbnbBackendApplication.class, args);
    }




}

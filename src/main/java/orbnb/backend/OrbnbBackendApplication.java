package orbnb.backend;

import orbnb.backend.model.Person;
import orbnb.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class OrbnbBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OrbnbBackendApplication.class, args);
    }

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        this.personRepository.save(new Person("Morgan", "Delange", "0648594859", "morgan@gmail.com", "loginMorgan", "mdpMorgan", "pictureMorgan", new Date(2000, 06, 25)));
        this.personRepository.save(new Person("Nader", "Chebbo", "0648594859", "nader@gmail.com", "loginNader", "mdpNader", "pictureNader", new Date(2000, 06, 25)));
        this.personRepository.save(new Person("Saba", "Ijaz", "0648594859", "saba@gmail.com", "loginSaba", "mdpSaba", "pictureSaba", new Date(2000, 06, 25)));
        this.personRepository.save(new Person("Meriam", "Bokri", "0648594859", "meriam@gmail.com", "loginMeriam", "mdpMeriam", "pictureMeriam", new Date(2000, 06, 25)));
    }
}

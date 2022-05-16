package orbnb.backend.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Person")
@Table(name = "PERSON")
@NoArgsConstructor
@Data
public class Person implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id_person")
    Long id_person;
    @Column(name="first_name")
    String first_name;
    @Column(name="last_name")
    String last_name;
    @Column(name="phone_number")
    Integer phone_number;
    @Column(name="email")
    String email;
    @Column(name="login")
    String login;
    @Column(name="password")
    String password;
    @Column(name="picture")
    String picture;
    @Temporal(TemporalType.DATE)
    @Column(name="date_of_birth")
    Date date_of_birth;
}
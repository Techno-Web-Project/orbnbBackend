package orbnb.backend.message;

import lombok.Data;
import lombok.NoArgsConstructor;
import orbnb.backend.housing.Housing;
import orbnb.backend.person.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="message")
@Data
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id_message")
    private Long id_message;

    @Column(name="text")
    private String text;

    @Temporal(TemporalType.DATE)
    @Column(name="date")
    private Date date;

    @Temporal(TemporalType.TIME)
    @Column(name="time")
    private Date time;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_person", referencedColumnName = "id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

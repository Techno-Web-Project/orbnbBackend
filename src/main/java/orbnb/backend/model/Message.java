package orbnb.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

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

/*    @OneToMany(mappedBy = "person")
    private List<Message> messages;

 */
}

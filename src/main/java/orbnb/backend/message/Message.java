package orbnb.backend.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private Long messageId;

    @Column(name = "text")
    private String text;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Temporal(TemporalType.TIME)
    @Column(name = "time")
    private Date time;

    @Column(name = "id_receiver")
    private Long idReceiver;

    @Column(name = "id_sender")
    private Long idSender;

}

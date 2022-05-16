package orbnb.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="person_rate")
@Data
@NoArgsConstructor
public class Person_rate {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="id_person_rate")
    private Long id_person_rate;
    @Column(name="rate")
    private Integer rate;
    @Column(name="comment")
    private String comment;
    @Temporal(TemporalType.DATE)
    @Column(name="rating_date")
    private Date rating_date;
}

package orbnb.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="personRate")
@Data
@NoArgsConstructor
public class PersonRate {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id_personRate")
    private Long id_person_rate;
    @Column(name="rate")
    private Integer rate;
    @Column(name="comment")
    private String comment;
    @Temporal(TemporalType.DATE)
    @Column(name="rating_date")
    private Date rating_date;
}

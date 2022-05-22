package orbnb.backend.personRate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personRate")
@Data
@NoArgsConstructor
public class PersonRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personRate")
    private Long personRateId;

    private Integer rate;

    private String comment;

    private Long PersonId;

    @Temporal(TemporalType.DATE)
    @Column(name = "rating_date")
    private Date ratingDate;
}

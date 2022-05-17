package orbnb.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "housingRate")
@NoArgsConstructor
@Data
public class HousingRate {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="id_housing_rate")
    private Long id_housing_rate;
    @Column(name="rate")
    private Integer rate;
    @Column(name="comment")
    private String comment;
    @Temporal(TemporalType.DATE)
    @Column(name="rating_date")
    private Date rating_date;

}

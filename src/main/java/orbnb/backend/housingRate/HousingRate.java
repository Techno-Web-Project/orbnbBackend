package orbnb.backend.housingRate;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_housing_rate")
    private Long housingRateId;

    private Integer rate;

    private String comment;

    private Long notedHousingId;

    @Temporal(TemporalType.DATE)
    @Column(name = "rating_date")
    private Date ratingDate;

}

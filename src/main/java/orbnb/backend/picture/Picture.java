package orbnb.backend.picture;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "picture")
@NoArgsConstructor
@Data
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_picture")
    private Long pictureId;

    private String title;

    @Column(name = "file_localisation")
    private String fileLocalisation;

    private Long housingId;
}

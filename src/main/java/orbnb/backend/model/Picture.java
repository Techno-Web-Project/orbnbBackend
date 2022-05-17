package orbnb.backend.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "picture")
@NoArgsConstructor
@Data
public class Picture {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="id_picture")
    private Long id_picture;
    @Column(name="title")
    private String title;
}

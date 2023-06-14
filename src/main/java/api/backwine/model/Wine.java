package api.backwine.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wines")
@Data
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}

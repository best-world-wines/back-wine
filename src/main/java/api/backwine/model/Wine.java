package api.backwine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "wine")
@Data
public class Wine {
    @Id
    private Long id;
    private String name;
    private String description;
}

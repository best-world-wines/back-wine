package api.backwine.model.wine;

import api.backwine.model.abstraction.SoftDeleteModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wine_types")
@Setter
@Getter
@NoArgsConstructor
public class WineType implements SoftDeleteModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "default_bottle_image")
    private String defaultBottleImage;
    @Column(name = "is_deleted")
    private boolean isDeleted = false;
}

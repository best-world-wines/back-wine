package api.backwine.model.product;

import api.backwine.model.abstraction.GlobalTimestampedEntity;
import api.backwine.model.listener.WineTypeListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
@EntityListeners(WineTypeListener.class)
public class WineType extends GlobalTimestampedEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "default_bottle_image")
    private String defaultBottleImage;
}

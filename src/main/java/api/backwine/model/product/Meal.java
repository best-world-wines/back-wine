package api.backwine.model.product;

import api.backwine.model.abstraction.GlobalTimestampedEntity;
import api.backwine.model.listener.MealListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "meals")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(MealListener.class)
public class Meal extends GlobalTimestampedEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String image;
}

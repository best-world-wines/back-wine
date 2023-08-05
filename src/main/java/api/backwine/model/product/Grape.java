package api.backwine.model.product;

import api.backwine.model.abstraction.GlobalTimestampedEntity;
import api.backwine.model.listener.GrapeListener;
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
@Table(name = "grapes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(GrapeListener.class)
public class Grape extends GlobalTimestampedEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
}

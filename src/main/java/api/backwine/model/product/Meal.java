package api.backwine.model.product;

import api.backwine.model.abstraction.SoftDeleteModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Meal implements SoftDeleteModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String image;
    @Column(name = "is_deleted")
    private boolean isDeleted = false;
}

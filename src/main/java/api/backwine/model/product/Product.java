package api.backwine.model.product;

import api.backwine.model.abstraction.SoftDeleteModel;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Products")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product implements SoftDeleteModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String mainImage;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "image")
    private List<String> images;
    private BigDecimal price;
    @Column(name = "quantity")
    private int quantityInStock;
    @Column(name = "is_empty")
    private boolean isEmpty;
    @Column(name = "is_deleted")
    private boolean isDeleted;

    public String getType() {
        return this.getClass().getSimpleName();
    }
}

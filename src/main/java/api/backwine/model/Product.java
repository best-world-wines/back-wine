package api.backwine.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {
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
}

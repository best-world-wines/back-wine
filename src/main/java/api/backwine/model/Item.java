package api.backwine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_type", nullable = false)
    private String productType;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Integer quantity;
    @Transient
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
        this.setProductType(product.getClass().getTypeName());
        this.setProductId(product.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(id, item.id)
                && Objects.equals(productType, item.productType)
                && Objects.equals(productId, item.productId)
                && Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productType, productId, quantity);
    }
}

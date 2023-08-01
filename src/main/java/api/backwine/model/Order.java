package api.backwine.model;

import api.backwine.model.abstraction.SoftDeleteModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order implements SoftDeleteModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "checkout_time")
    private LocalDateTime checkoutTime;
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column(name = "is_canceled")
    private boolean isCanceled = false;
    @Column(name = "is_deleted")
    private boolean isDeleted = false;
}

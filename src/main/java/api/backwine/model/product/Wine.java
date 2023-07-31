package api.backwine.model.product;

import api.backwine.model.listener.GlobalTimestampedEntity;
import api.backwine.model.listener.WineListener;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wines")
@Setter
@Getter
@NoArgsConstructor
@EntityListeners(WineListener.class)
public class Wine extends GlobalTimestampedEntity implements GlobalProductIdentifiable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "style_id")
    private WineStyle wineStyle;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private WineType wineType;
    private String mainImage;
    @ElementCollection
    @Column(name = "image")
    private List<String> images;
    private BigDecimal price;
    @Column(name = "bottle_volume")
    private Double bottleVolume;
    private Double alcohol;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Integer year;
    @Column(name = "winery_name")
    private String wineryName;
    @ManyToMany
    @JoinTable(
            name = "region_wines",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "region_id")
    )
    private List<Region> regions;
    private double acidityValue;
    private double fizzinessValue;
    private double intensityValue;
    private double sweetnessValue;
    private double tanninValue;
    @ManyToMany
    @JoinTable(
            name = "wine_meals",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals;
    @ManyToMany
    @JoinTable(
            name = "wine_grapes",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "grape_id")
    )
    private List<Grape> grapes;
    private int quantityInStock;
}
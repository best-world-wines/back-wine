package api.backwine.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wines")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @Column(name = "bottle_volume")
    private Double bottleVolume;
    private String description;
    private Integer year;
    @ManyToOne
    @JoinColumn(name = "winery_id")
    private Winery winery;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
    @ElementCollection
    @CollectionTable(
            name = "wines_interesting_facts",
            joinColumns = @JoinColumn(name = "wine_id")
    )
    @Column(name = "interesting_fact")
    private List<String> interestingFacts;
    @ManyToMany
    @JoinTable(
            name = "wines_tastes",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "taste_id")
    )
    private List<Taste> tastes;
    @ManyToMany
    @JoinTable(
            name = "wines_meals",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals;
    @ManyToMany
    @JoinTable(
            name = "wines_grapes",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "grape_id")
    )
    private List<Grape> grapes;
    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isDeleted;

    @Override
    public String toString() {
        return "Wine{"
                + "id=" + id + '\''
                + ", name='" + name + '\''
                + ", price=" + price + '\''
                + ", bottleVolume=" + bottleVolume + '\''
                + ", description='" + description + '\''
                + ", year=" + year + '\''
                + ", winery=" + winery + '\''
                + ", region=" + region + '\''
                + ", interestingFacts=" + interestingFacts + '\''
                + ", tastes=" + tastes + '\''
                + ", meals=" + meals + '\''
                + ", grapes=" + grapes + '\''
                + ", isDeleted=" + isDeleted + '\''
                + '}';
    }
}
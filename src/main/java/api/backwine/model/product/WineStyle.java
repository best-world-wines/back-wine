package api.backwine.model.product;

import api.backwine.model.abstraction.SoftDeleteModel;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wine_styles")
@Setter
@Getter
@NoArgsConstructor
public class WineStyle implements SoftDeleteModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "regional_name")
    private String regionalName;
    @Column(name = "varietal_name")
    private String varietalName;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ElementCollection
    @CollectionTable(
            name = "style_interesting_fact",
            joinColumns = @JoinColumn(name = "wine_style_id")
    )
    @Column(name = "interesting_facts", columnDefinition = "TEXT")
    private List<String> interestingFacts;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private WineType wineType;
    @Column(name = "is_deleted")
    private boolean isDeleted = false;
}

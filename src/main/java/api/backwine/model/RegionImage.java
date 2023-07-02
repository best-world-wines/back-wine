package api.backwine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "region_images")
@Setter
@Getter
@NoArgsConstructor
public class RegionImage {
    @Id
    private Long id;
    @MapsId
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id")
    private Region region;
    private String type;
    @Column(name = "url_path")
    private String urlPath;
    private byte[] content;
}

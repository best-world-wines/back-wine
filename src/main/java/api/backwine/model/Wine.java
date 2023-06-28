package api.backwine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import lombok.Data;

@Entity
@Table(name = "wines")
@Data
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String name;
    @Column(name = "seo_name")
    private String seoName;
    private String description;
    private int year;
    private String region;
    private String winery;
    @ElementCollection
    private List<String> taste;
    @ElementCollection
    private List<String> grapes;
    @ElementCollection
    @Column(name = "interesting_facts")
    private List<String> interestingFacts;

    public Wine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeoName() {
        return seoName;
    }

    public void setSeoName(String seoName) {
        this.seoName = seoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public List<String> getTaste() {
        return taste;
    }

    public void setTaste(List<String> taste) {
        this.taste = taste;
    }

    public List<String> getGrapes() {
        return grapes;
    }

    public void setGrapes(List<String> grapes) {
        this.grapes = grapes;
    }

    public List<String> getInterestingFacts() {
        return interestingFacts;
    }

    public void setInterestingFacts(List<String> interestingFacts) {
        this.interestingFacts = interestingFacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wine wine = (Wine) o;
        return year == wine.year
                && Objects.equals(id, wine.id)
                && Objects.equals(image, wine.image)
                && Objects.equals(name, wine.name)
                && Objects.equals(seoName, wine.seoName)
                && Objects.equals(description, wine.description)
                && Objects.equals(region, wine.region)
                && Objects.equals(winery, wine.winery)
                && Objects.equals(taste, wine.taste)
                && Objects.equals(grapes, wine.grapes)
                && Objects.equals(interestingFacts, wine.interestingFacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, name, seoName, description,
                year, region, winery, taste, grapes, interestingFacts);
    }

    @Override
    public String toString() {
        return "Wine{"
                + "id=" + id
                + ", image='" + image + '\''
                + ", name='" + name + '\''
                + ", seoName='" + seoName + '\''
                + ", description='" + description + '\''
                + ", year=" + year
                + ", region='" + region + '\''
                + ", winery='" + winery + '\''
                + ", taste=" + taste
                + ", grapes=" + grapes
                + ", interestingFacts=" + interestingFacts
                + '}';
    }
}
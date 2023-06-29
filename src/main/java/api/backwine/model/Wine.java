package api.backwine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;

@Entity
@Table(name = "wines")
@Data
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> images;
    private String name;
    private String varietal;
    private double price;
    @Column(name = "bottle_volume")
    private double bottleVolume;
    private int year;
    private String country;
    private String region;
    private String winery;
    private String description;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Map<TasteType, Double> tastes;
    @ElementCollection
    private List<String> grapes;
    @ElementCollection
    @Column(name = "interesting_facts")
    private List<String> interestingFacts;

    public Wine() {
    }

    public enum TasteType {
        ACIDITY,
        FIZZINESS,
        INTENSITY,
        SWEETNESS,
        TANNIN
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVarietal() {
        return varietal;
    }

    public void setVarietal(String varietal) {
        this.varietal = varietal;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBottleVolume() {
        return bottleVolume;
    }

    public void setBottleVolume(double bottleVolume) {
        this.bottleVolume = bottleVolume;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<TasteType, Double> getTastes() {
        return tastes;
    }

    public void setTastes(Map<TasteType, Double> tastes) {
        this.tastes = tastes;
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
        return Double.compare(wine.price, price) == 0
                && Double.compare(wine.bottleVolume, bottleVolume) == 0
                && year == wine.year && Objects.equals(id, wine.id)
                && Objects.equals(images, wine.images)
                && Objects.equals(name, wine.name)
                && Objects.equals(varietal, wine.varietal)
                && Objects.equals(country, wine.country)
                && Objects.equals(region, wine.region)
                && Objects.equals(winery, wine.winery)
                && Objects.equals(description, wine.description)
                && Objects.equals(tastes, wine.tastes)
                && Objects.equals(grapes, wine.grapes)
                && Objects.equals(interestingFacts, wine.interestingFacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, images, name, varietal, price, bottleVolume, year,
                country, region, winery, description, tastes, grapes, interestingFacts);
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id
                + ", images=" + images
                + ", name='" + name + '\''
                + ", varietal='" + varietal + '\''
                + ", price=" + price
                + ", bottleVolume=" + bottleVolume
                + ", year=" + year
                + ", country='" + country + '\''
                + ", region='" + region + '\''
                + ", winery='" + winery + '\''
                + ", description='" + description + '\''
                + ", tastes=" + tastes
                + ", grapes=" + grapes
                + ", interestingFacts=" + interestingFacts
                + '}';
    }
}
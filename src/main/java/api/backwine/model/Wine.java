package api.backwine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Data;

@Entity
@Table(name = "wines")
@Data
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    private String type;
    private String country;
    private String region;
    private String subregion;
    private String classification;
    @Column(name = "harvestyear")
    private int harvestYear;
    private String variety;
    private String strength;
    private double volume;
    private String producer;

    public Wine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getHarvestYear() {
        return harvestYear;
    }

    public void setHarvestYear(int harvestYear) {
        this.harvestYear = harvestYear;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Wine{"
                + "id=" + id
                + ", color='" + color + '\''
                + ", type='" + type + '\''
                + ", country='" + country + '\''
                + ", region='" + region + '\''
                + ", subregion='" + subregion + '\''
                + ", classification='" + classification + '\''
                + ", harvestYear=" + harvestYear
                + ", variety='" + variety + '\''
                + ", strength='" + strength + '\''
                + ", volume=" + volume
                + ", producer='" + producer + '\''
                + '}';
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
        return harvestYear == wine.harvestYear
                && Double.compare(wine.volume, volume) == 0
                && Objects.equals(id, wine.id)
                && Objects.equals(color, wine.color)
                && Objects.equals(type, wine.type)
                && Objects.equals(country, wine.country)
                && Objects.equals(region, wine.region)
                && Objects.equals(subregion, wine.subregion)
                && Objects.equals(classification, wine.classification)
                && Objects.equals(variety, wine.variety)
                && Objects.equals(strength, wine.strength)
                && Objects.equals(producer, wine.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, type, country,
                region, subregion,
                classification, harvestYear,
                variety, strength,
                volume, producer);
    }
}

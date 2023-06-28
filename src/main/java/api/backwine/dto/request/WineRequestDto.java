package api.backwine.dto.request;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WineRequestDto {
    @NotNull
    private String image;
    @NotNull
    private String name;
    @NotNull
    private String seoName;
    @NotNull
    private String description;
    @NotNull
    private int year;
    @NotNull
    private String region;
    @NotNull
    private String winery;
    @NotNull
    private List<String> taste;
    @NotNull
    private List<String> grapes;
    @NotNull
    private List<String> interestingFacts;
}

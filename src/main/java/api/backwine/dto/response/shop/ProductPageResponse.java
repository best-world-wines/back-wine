package api.backwine.dto.response.shop;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductPageResponse<T> {
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long productsAmount;
    private boolean isLastPage;
    private List<T> productsDto;
}

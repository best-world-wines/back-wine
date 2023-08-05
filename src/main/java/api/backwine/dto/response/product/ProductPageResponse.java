package api.backwine.dto.response.product;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductPageResponse<ENTITY> {
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long productsAmount;
    private boolean isLastPage;
    private List<ENTITY> productsDto;
}

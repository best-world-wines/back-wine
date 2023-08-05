package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.GlobalToDtoMapper;
import api.backwine.dto.response.product.ProductPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductPageMapper<ENTITY, RESPONSE> {

    public ProductPageResponse<RESPONSE> toDto(Page<ENTITY> page,
                                               GlobalToDtoMapper<ENTITY, RESPONSE> mapper) {
        ProductPageResponse<RESPONSE> productPage = new ProductPageResponse<>();
        productPage.setPageNumber(page.getNumber());
        productPage.setPageSize(page.getSize());
        productPage.setTotalPages(page.getTotalPages());
        productPage.setProductsAmount(page.getTotalElements());
        productPage.setLastPage(page.isLast());
        productPage.setProductsDto(page.getContent()
                .stream()
                .map(mapper::toDto)
                .toList());
        return productPage;
    }
}

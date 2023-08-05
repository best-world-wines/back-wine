package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.MapperToDto;
import api.backwine.dto.response.product.ProductPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductPageMapper<M, R> {

    public ProductPageResponse<R> toDto(Page<M> page, MapperToDto<M, R> mapper) {
        ProductPageResponse<R> productPage = new ProductPageResponse<>();
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

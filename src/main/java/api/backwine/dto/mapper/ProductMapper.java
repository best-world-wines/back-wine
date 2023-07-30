package api.backwine.dto.mapper;

import api.backwine.dto.response.ProductResponseDto;
import api.backwine.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements MapperToDto<Product, ProductResponseDto> {

    @Override
    public ProductResponseDto toDto(Product product) {
        ProductResponseDto productDto = new ProductResponseDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setMainImage(product.getMainImage());
        return productDto;
    }
}

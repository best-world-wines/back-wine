package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.GlobalToDtoMapper;
import api.backwine.dto.response.product.ProductResponseDto;
import api.backwine.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements GlobalToDtoMapper<Product, ProductResponseDto> {

    @Override
    public ProductResponseDto toDto(Product product) {
        ProductResponseDto productDto = new ProductResponseDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setMainImage(product.getMainImage());
        productDto.setType(product.getType());
        return productDto;
    }
}

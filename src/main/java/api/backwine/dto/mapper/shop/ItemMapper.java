package api.backwine.dto.mapper.shop;

import api.backwine.dto.mapper.product.ProductMapper;
import api.backwine.dto.request.shop.ItemRequestDto;
import api.backwine.dto.response.shop.ItemResponseDto;
import api.backwine.model.shop.Item;
import api.backwine.model.product.Product;
import api.backwine.service.product.ProductService;
import api.backwine.lib.PathConverter;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    private final ProductMapper productMapper;
    private final ProductService<Product> productService;

    public ItemMapper(ProductMapper productMapper, ProductService<Product> productService) {
        this.productMapper = productMapper;
        this.productService = productService;
    }

    public Item toModel(ItemRequestDto itemDto) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setProduct(productService.getById(itemDto.getProductId()));
        item.setQuantity(itemDto.getQuantity());
        return item;
    }

    public ItemResponseDto toDto(Item item) {
        ItemResponseDto itemDto = new ItemResponseDto();
        itemDto.setId(item.getId());
        itemDto.setProductDto(productMapper.toDto(item.getProduct()));
        itemDto.setQuantity(item.getQuantity());
        itemDto.setProductLink(PathConverter.convertToApiPath(item.getProduct().getType())
                + item.getProduct().getId());
        return itemDto;
    }
}

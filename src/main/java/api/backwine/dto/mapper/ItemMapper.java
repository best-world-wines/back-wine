package api.backwine.dto.mapper;

import api.backwine.dto.request.ItemRequestDto;
import api.backwine.dto.response.ItemResponseDto;
import api.backwine.model.Item;
import api.backwine.model.Product;
import api.backwine.service.ProductService;
import api.backwine.util.PathConverter;
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

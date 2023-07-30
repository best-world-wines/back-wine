package api.backwine.dto.mapper;

import api.backwine.dto.request.ItemRequestDto;
import api.backwine.dto.response.ItemResponseDto;
import api.backwine.model.Item;
import api.backwine.model.Product;
import api.backwine.service.ProductService;
import api.backwine.util.PathConverter;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    private final Map<Class<? extends Product>, ProductService<Product, Long>> productServicesMap;
    private final ProductMapper productMapper;

    public ItemMapper(
            Map<Class<? extends Product>, ProductService<Product, Long>> productServicesMap,
            ProductMapper productMapper) {
        this.productMapper = productMapper;
        this.productServicesMap = productServicesMap;
    }

    public Item toModel(ItemRequestDto itemDto) {
        Item item = new Item();
        item.setId(itemDto.getId());
        try {
            item.setProduct(productServicesMap.get(
                    Class.forName(PathConverter.convertToModelPath(itemDto.getProductType())))
                    .getProductById((itemDto.getProductId())));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Not found product of required type "
                    + itemDto.getProductType());
        }
        item.setQuantity(itemDto.getQuantity());
        return item;
    }

    public ItemResponseDto toDto(Item item) {
        ItemResponseDto itemDto = new ItemResponseDto();
        itemDto.setId(item.getId());
        itemDto.setProductDto(productMapper.toDto(item.getProduct()));
        itemDto.setQuantity(item.getQuantity());
        itemDto.setProductType(item.getProduct().getClass().getSimpleName());
        itemDto.setProductLink(
                PathConverter.convertToApiPath(item.getProductType()) + item.getProductId());
        return itemDto;
    }
}

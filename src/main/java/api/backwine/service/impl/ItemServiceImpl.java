package api.backwine.service.impl;

import api.backwine.model.Item;
import api.backwine.model.Product;
import api.backwine.repository.ItemRepository;
import api.backwine.service.ItemService;
import api.backwine.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item, Long> implements ItemService {
    private final Map<Class<? extends Product>, ProductService<Product, Long>> productServicesMap;
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository, Map<Class<? extends Product>,
            ProductService<Product, Long>> productServicesMap) {
        super(Item.class, itemRepository);
        this.productServicesMap = productServicesMap;
        this.itemRepository = itemRepository;
    }

    @Override
    protected Item putId(Long id, Item item) {
        item.setId(id);
        return item;
    }

    @Override
    public Item getById(Long id) {
        Item item = super.getById(id);
        try {
            item.setProduct(productServicesMap.get(Class.forName(item.getProductType()))
                    .getById(item.getProductId()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Not found product of required type "
                    + item.getProductType());
        }
        return item;
    }

    @Override
    public boolean deleteItems(List<Item> items) {
        itemRepository.deleteAllInBatch(items);
        return true;
    }
}

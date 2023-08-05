package api.backwine.service.shop.impl;

import api.backwine.model.shop.Item;
import api.backwine.repository.shop.ItemRepository;
import api.backwine.service.impl.GenericServiceImpl;
import api.backwine.service.shop.ItemService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item, Long> implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        super(Item.class, itemRepository);
        this.itemRepository = itemRepository;
    }

    @Override
    public boolean deleteItems(List<Item> items) {
        itemRepository.deleteAllInBatch(items);
        return true;
    }
}

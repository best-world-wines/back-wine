package api.backwine.service.impl;

import api.backwine.model.Item;
import api.backwine.repository.ItemRepository;
import api.backwine.service.ItemService;
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

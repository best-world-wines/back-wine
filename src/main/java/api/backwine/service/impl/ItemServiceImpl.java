package api.backwine.service.impl;

import api.backwine.model.Item;
import api.backwine.repository.ItemRepository;
import api.backwine.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item, Long> implements ItemService {

    public ItemServiceImpl(ItemRepository itemRepository) {
        super(Item.class, itemRepository);
    }

    @Override
    protected Item putId(Long id, Item item) {
        item.setId(id);
        return item;
    }
}

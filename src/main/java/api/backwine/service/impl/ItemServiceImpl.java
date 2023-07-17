package api.backwine.service.impl;

import api.backwine.model.Item;
import api.backwine.repository.ItemRepository;
import api.backwine.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item create(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get cart item by id " + id));
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        itemRepository.deleteById(id);
        return true;
    }

    @Override
    public Item update(Long id, Item item) {
        item.setId(id);
        return itemRepository.save(item);
    }
}

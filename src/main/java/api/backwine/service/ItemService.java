package api.backwine.service;

import api.backwine.model.Item;
import java.util.List;

public interface ItemService extends GenericService<Item, Long> {
    boolean deleteItems(List<Item> items);
}

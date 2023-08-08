package api.backwine.service.shop;

import api.backwine.model.shop.Item;
import api.backwine.service.GenericService;
import java.util.List;

public interface ItemService extends GenericService<Item, Long> {
    boolean deleteItems(List<Item> items);
}

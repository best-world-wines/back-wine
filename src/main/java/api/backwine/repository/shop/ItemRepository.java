package api.backwine.repository.shop;

import api.backwine.model.shop.Item;
import api.backwine.repository.GlobalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends GlobalRepository<Item, Long> {
}

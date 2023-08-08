package api.backwine.service.shop;

import api.backwine.model.shop.Address;
import api.backwine.model.shop.User;
import api.backwine.service.GenericService;
import java.util.List;

public interface AddressService extends GenericService<Address, Long> {
    List<Address> findAllByUser(User user);
}

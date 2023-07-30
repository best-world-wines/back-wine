package api.backwine.service;

import api.backwine.model.Address;
import api.backwine.model.User;
import java.util.List;

public interface AddressService extends GenericService<Address, Long> {
    List<Address> findAllByUser(User user);
}

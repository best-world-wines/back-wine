package api.backwine.service.shop.impl;

import api.backwine.model.shop.Address;
import api.backwine.model.shop.User;
import api.backwine.repository.shop.AddressRepository;
import api.backwine.service.GenericServiceImpl;
import api.backwine.service.shop.AddressService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends GenericServiceImpl<Address, Long>
        implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        super(Address.class, addressRepository);
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAllByUser(User user) {
        return addressRepository.findAllByUser(user);
    }
}

package api.backwine.service.impl;

import api.backwine.model.Address;
import api.backwine.model.User;
import api.backwine.repository.AddressRepository;
import api.backwine.service.AddressService;
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

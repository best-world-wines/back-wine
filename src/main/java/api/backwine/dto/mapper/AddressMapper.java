package api.backwine.dto.mapper;

import api.backwine.dto.request.AddressRequestDto;
import api.backwine.dto.response.AddressResponseDto;
import api.backwine.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements MapperToModel<Address, AddressRequestDto>,
        MapperToDto<Address, AddressResponseDto>{
    @Override
    public Address toModel(AddressRequestDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHouse(addressDto.getHouse());
        address.setApartment(addressDto.getApartment());
        return address;
    }

    @Override
    public AddressResponseDto toDto(Address address) {
        AddressResponseDto addressDto = new AddressResponseDto();
        addressDto.setId(address.getId());
        addressDto.setCity(addressDto.getCity());
        addressDto.setStreet(addressDto.getStreet());
        addressDto.setHouse(addressDto.getHouse());
        addressDto.setApartment(addressDto.getApartment());
        return addressDto;
    }
}
package api.backwine.dto.mapper.shop;

import api.backwine.dto.mapper.MapperToDto;
import api.backwine.dto.mapper.MapperToModel;
import api.backwine.dto.request.shop.AddressRequestDto;
import api.backwine.dto.response.shop.AddressResponseDto;
import api.backwine.model.shop.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements MapperToModel<Address, AddressRequestDto>,
        MapperToDto<Address, AddressResponseDto> {
    @Override
    public Address toModel(AddressRequestDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHouse(addressDto.getHouse());
        address.setApartment(addressDto.getApartment() == null ? "" : addressDto.getApartment());
        return address;
    }

    @Override
    public AddressResponseDto toDto(Address address) {
        AddressResponseDto addressDto = new AddressResponseDto();
        addressDto.setId(address.getId());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setHouse(address.getHouse());
        addressDto.setApartment(addressDto.getApartment());
        return addressDto;
    }
}

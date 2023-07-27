package api.backwine.dto.mapper.shop;

import api.backwine.dto.mapper.GlobalToDtoMapper;
import api.backwine.dto.response.shop.RoleResponseDto;
import api.backwine.model.shop.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements GlobalToDtoMapper<Role, RoleResponseDto> {

    @Override
    public RoleResponseDto toDto(Role role) {
        RoleResponseDto roleDto = new RoleResponseDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getRoleName().name());
        return roleDto;
    }
}

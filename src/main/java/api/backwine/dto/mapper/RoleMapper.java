package api.backwine.dto.mapper;

import api.backwine.dto.response.RoleResponseDto;
import api.backwine.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    RoleResponseDto mapToDto(Role role) {
        RoleResponseDto roleDto = new RoleResponseDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getRoleName().name());
        return roleDto;
    }
}

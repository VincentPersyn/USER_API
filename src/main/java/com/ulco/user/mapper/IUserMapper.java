package com.ulco.user.mapper;

import com.ulco.user.dto.UserDTO;
import com.ulco.user.model.UserDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    UserDTO toUserDTO(UserDO userDO);

    UserDO toUserDO(UserDTO userDTO);
}

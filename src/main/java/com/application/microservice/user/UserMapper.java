package com.application.microservice.user;

import com.application.microservice.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
        @Mapping(source = "id", target = "idUser"),
        @Mapping(source = "username", target = "username")
    })

    UserDTO toDTO(User source);

    default List<UserDTO> toDTOList(List<User> userList){
        return userList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    default Page<UserDTO> toDTOList(Page<User> userList){
        return userList.map(this::toDTO);
    }

}

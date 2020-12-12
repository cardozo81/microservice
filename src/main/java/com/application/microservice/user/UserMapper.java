package com.application.microservice.user;

import com.application.microservice.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Mapper(componentModel = "spring", uses = {UserMapper.class})
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
        @Mapping(source = "id", target = "idUser"),
        @Mapping(source = "username", target = "username")
    })

    UserDTO toDTO(User source);

    default List<UserDTO> toDTOList(List<User> userList){
        if(userList == null){
            return new ArrayList<UserDTO>();
        }
        return userList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}

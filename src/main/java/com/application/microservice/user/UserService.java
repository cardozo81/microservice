package com.application.microservice.user;

import com.application.microservice.domain.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService {

    //@Autowired
    UserRepository userRepository;

    public Long execute(User user){

        userRepository.save(user);

        return user.getId();

    }

    public List<UserDTO> listAll(){

        //List<UserDTO> userDTOS = UserMapper.INSTANCE.toDTOList(userRepository.findAll());
        return null;

    }
}

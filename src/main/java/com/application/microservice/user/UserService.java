package com.application.microservice.user;

import com.application.microservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public Long execute(User user){
        userRepository.save(user);
        return user.getId();
    }

    public Long deleteById(Long id){
        userRepository.deleteById(id);
        return id;
    }


    public List<UserDTO> listAll(){
        return userMapper.toDTOList(userRepository.findAll());
    }

    public Page<UserDTO> listAll(Pageable pageable){
        return userMapper.toDTOList(userRepository.findAll(pageable));
    }
}

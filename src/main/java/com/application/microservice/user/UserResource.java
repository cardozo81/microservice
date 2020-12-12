package com.application.microservice.user;

import com.application.microservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public long create(@RequestBody UserDTO userDTO){

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setIdUserStatus(1);

        userService.execute(user);

        return user.getId();
    }

    @GetMapping("/users")
    public List<UserDTO> list() {
        return userService.listAll();
    }
}

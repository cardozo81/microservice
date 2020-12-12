package com.application.microservice.user;

import com.application.microservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public Long create(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setIdUserStatus(1);
        userService.execute(user);
        return user.getId();
    }

    @DeleteMapping
    public Long delete(@RequestBody UserDTO userDTO){
        return null;
    }

    @PutMapping
    public Long update(@RequestBody UserDTO userDTO){
        return null;
    }

    @GetMapping("/list")
    public List<UserDTO> list() {
        return userService.listAll();
    }

    @GetMapping("/page")
    public Page<UserDTO> list(@SortDefault.SortDefaults(value = {
            @SortDefault(value = "id", direction = Sort.Direction.DESC),
            @SortDefault(value = "username", direction = Sort.Direction.ASC)
        }) Pageable pageable) {
        return userService.listAll(pageable);
    }
}

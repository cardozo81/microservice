package com.application.microservice.user;

import com.application.microservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Long create(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setIdUserStatus(1);
        return userService.execute(user);
        //return userRepository.save(user).getId();
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long idUser){
        return userRepository.findById(idUser)
                .map(record -> {
                    //userRepository.deleteById(idUser);
                    userService.deleteById(idUser);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity update(@PathVariable("id") Long idUser, @RequestBody UserDTO userDTO){
        return userRepository.findById(idUser)
                .map(record -> {
                    record.setUsername(userDTO.getUsername());
                    record.setIdUserStatus(userDTO.getIdUserStatus());
                    //User updated = userRepository.save(record);
                    Long updated = userService.execute(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
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

package net.javaguides.springbootrestfulwebservices.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfulwebservices.entity.User;
import net.javaguides.springbootrestfulwebservices.service.Interface.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User result =  userService.createUser(user);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(User user) {
        List<User> userList = userService.getUsers();
        return  ResponseEntity.ok().body(userList);
    }


    @PutMapping("/update/{id}")
    public  ResponseEntity<User> updateUser(@NotNull @RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        User result =  userService.updateUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

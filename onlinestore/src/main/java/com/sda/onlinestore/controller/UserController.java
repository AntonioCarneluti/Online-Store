package com.sda.onlinestore.controller;

import com.sda.onlinestore.common.utils.AuthenticationBean;
import com.sda.onlinestore.dto.UserDto;
import com.sda.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
    }


    @GetMapping("/getUsers")
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
    }

    @GetMapping("/getUserById/{id}")
    public UserDto findByID(@PathVariable(name = "id") Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/getUserByUsername/{username}")
    public UserDto findByUsername(@PathVariable(name = "username") String username){
        return userService.findUserByUsername(username);
    }


    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/updateUserToAdmin")
    public void updateUserToAdmin(@RequestBody UserDto userDto){userService.updateUserToAdmin(userDto);}

}

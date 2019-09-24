package com.lee.redis.api;

import com.lee.redis.domain.User;
import com.lee.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<User> userList() {
        return userService.findAll();
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User show(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User update(@RequestBody User user) {
        return userService.save(user);
    }
}

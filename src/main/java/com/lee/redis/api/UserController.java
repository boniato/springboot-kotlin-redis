package com.lee.redis.api;

import com.lee.redis.domain.User;
import com.lee.redis.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(path = "/api")
@Api(value = "/api", description = "user", tags = {"User"})
@ApiResponses(value = {
    @ApiResponse(code = 400, message = "Wrong Type Parameter"),
    @ApiResponse(code = 404, message = "Does not exists sellers"),
    @ApiResponse(code = 500, message = "Server Error")})
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Getting all user information",
                  notes = "This API is to get all user information")
    @GetMapping(path = "/user")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @ApiOperation(value = "Getting an user information by user ID",
                  notes = "This API is to get an user information by user ID")
    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @ApiOperation(value = "Saving an user information",
                  notes = "This API is to save an user information")
    @PostMapping(value = "/user")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
}

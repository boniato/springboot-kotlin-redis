package com.lee.redis.api

import com.lee.redis.domain.User
import com.lee.redis.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = ["/api"])
@Api(value = "/api", description = "user", tags = ["User"])
@ApiResponses(value = [ApiResponse(code = 400, message = "Wrong Type Parameter")
                     , ApiResponse(code = 404, message = "User does not exist")
                     , ApiResponse(code = 500, message = "Server Error")])
class UserController(private val userService: UserService) {

    val users: MutableList<User>
    @ApiOperation(value = "Getting all user information"
                , notes = "This API is to get all user information")
    @GetMapping(path = ["/user"])
    get() = userService!!.findAll()

    @ApiOperation(value = "Getting an user information by user ID"
                , notes = "This API is to get an user information by user ID")
    @GetMapping("/user/{id}")
    fun getUser(@PathVariable("id") id: String): User {
        return userService!!.findById(id)
    }

    @ApiOperation(value = "Saving an user information"
                , notes = "This API is to save an user information")
    @PostMapping("/user")
    fun save(@RequestBody user: User): User {
        return userService!!.save(user)
    }

}

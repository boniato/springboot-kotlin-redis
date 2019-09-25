package com.lee.redis.repository

import com.lee.redis.domain.User
import com.lee.redis.service.UserService
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.assertj.core.api.Assertions.assertThat


@RunWith(SpringRunner::class)
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private lateinit var userService: UserService

    val user = User("foo","Lee",20)

    @After
    fun delete() {
        userService.delete(user)
    }

    @Test
    fun save() {
        val savedUser = userService.save(user)
        assertThat(savedUser.id).isEqualTo(user.id)
    }
}

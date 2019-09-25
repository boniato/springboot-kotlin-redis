package com.lee.redis.repository

import com.lee.redis.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRedisRepository : CrudRepository<User, String> {

    fun findAllBy(): MutableList<User>

    fun findBy(id: String): User
}

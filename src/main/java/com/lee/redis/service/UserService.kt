package com.lee.redis.service

import com.lee.redis.domain.User
import com.lee.redis.repository.UserRedisRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRedisRepository: UserRedisRepository) {

    fun findAll(): MutableList<User> {
        return userRedisRepository.findAllBy()
    }

    fun findById(id: String): User {
        return userRedisRepository.findBy(id)
    }

    fun save(user: User): User {
        userRedisRepository.save(user)
        return findById(user.id)
    }

    fun delete(user: User) {
        userRedisRepository.delete(user)
    }
}

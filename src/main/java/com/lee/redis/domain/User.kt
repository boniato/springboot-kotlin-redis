package com.lee.redis.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("user")
class User (
    @Id
    var id: String,
    var name: String,
    var age: Int
)
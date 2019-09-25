package com.lee.redis.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import redis.embedded.RedisServer
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
import java.io.IOException

@Profile("local")
@Configuration
class EmbeddedRedisConfig {

    @Value("\${spring.redis.port}")
    private val redisPort: Int = 0

    private var redisServer: RedisServer? = null

    @PostConstruct
    @Throws(IOException::class)
    fun redisServer() {
        redisServer = RedisServer(redisPort)
        redisServer!!.start()
    }

    @PreDestroy
    fun stopRedis() {
        if (redisServer != null) {
            redisServer!!.stop()
        }
    }
}

package com.lee.redis.repository;

import com.lee.redis.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRedisRepository extends CrudRepository<User, String> {
}

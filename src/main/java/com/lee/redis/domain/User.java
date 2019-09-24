package com.lee.redis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
@RedisHash("user")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private static long longId = 100;

    @Id
    private String id;
    @NotEmpty
    @Size(min = 5, max = 100)
    private String name;
    private int age;

    public User() {
        this.id = generateNextId();
    }

    public static String generateNextId() {
        return String.valueOf(longId++);
    }
}

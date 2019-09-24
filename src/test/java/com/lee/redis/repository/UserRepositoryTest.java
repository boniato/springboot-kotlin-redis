package com.lee.redis.repository;

import com.lee.redis.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    User user = new User();

    @Before
    public void setUser() {
        user = User.builder()
                    .id(User.generateNextId())
                    .name("Lee")
                    .age(30)
                    .build();
    }

    @After
    public void delete() {
        userRepository.delete(user);
    }

    @Test
    public void save() {
        userRepository.save(user);
        User savedUser = userRepository.findById(user.getId());
        assertThat(savedUser.getName()).isEqualTo(savedUser.getName());
    }
}

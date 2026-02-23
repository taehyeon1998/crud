package com.example.mentoring.user.service;

import com.example.mentoring.common.exception.DuplicateResourceException;
import com.example.mentoring.user.domain.User;
import com.example.mentoring.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("유저 생성 성공")
    public void create_success(){
        User user = userService.create("gon");
        assertThat(user.getId()).isNotNull();
        assertThat(user.getName()).isEqualTo("gon");
    }

    @Test
    @DisplayName("중복 이름 생성 시 에외 발생")
    public void create_duplicate(){
        userService.create("duplicate");

        assertThatThrownBy(()->userService.create("duplicate"))
                .isInstanceOf(DuplicateResourceException.class);
    }
}

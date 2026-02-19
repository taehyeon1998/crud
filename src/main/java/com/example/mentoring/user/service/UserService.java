package com.example.mentoring.user.service;


import com.example.mentoring.user.domain.User;
import com.example.mentoring.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User create(String name) {
        User user = User.builder().name(name).build();

        return userRepository.save(user);
    }
}

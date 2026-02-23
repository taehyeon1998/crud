package com.example.mentoring.user.service;


import com.example.mentoring.common.exception.DuplicateResourceException;
import com.example.mentoring.user.domain.User;
import com.example.mentoring.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User create(String name) {

        if (userRepository.existsByName(name)) {
            throw new DuplicateResourceException("이미 존재하는 이름입니다.");
        }
        User user = User.builder().name(name).build();

        return userRepository.save(user);
    }

    @Transactional
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("존재하지 않는 유저입니다."));

    }

    @Transactional
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public User updateName(Long id, String name){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다"));

        if(userRepository.existsByName(name)){
            throw new DuplicateResourceException("이미 존재하는 이름입니다");
        }

        user.changeName(name);
        return user;
    }

    @Transactional
    public void delete(Long id){
        if(!userRepository.existsById(id)){
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }

        userRepository.deleteById(id);
    }
}

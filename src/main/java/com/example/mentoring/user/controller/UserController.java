package com.example.mentoring.user.controller;


import com.example.mentoring.user.domain.User;
import com.example.mentoring.user.repository.UserRepository;
import com.example.mentoring.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/create")
    public User create(@RequestParam String name){
        return userService.create(name);
    }
}

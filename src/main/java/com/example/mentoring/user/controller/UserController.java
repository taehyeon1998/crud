package com.example.mentoring.user.controller;


import com.example.mentoring.user.controller.dto.CreateUserRequest;
import com.example.mentoring.user.controller.dto.UpdateUserRequest;
import com.example.mentoring.user.controller.dto.UserResponse;
import com.example.mentoring.user.domain.User;
import com.example.mentoring.user.repository.UserRepository;
import com.example.mentoring.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse create(@RequestBody @Valid CreateUserRequest request ) {
        User user = userService.create(request.getName());
        return new UserResponse(user.getId(), user.getName());
    }

    @GetMapping("/{id}")
    public UserResponse getOne(@PathVariable Long id) {
        User user = userService.findById(id);
        return UserResponse.from(user.getId(), user.getName());
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.findAll().stream()
                .map(u -> UserResponse.from(u.getId(), u.getName()))
                .toList();
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody   @Valid UpdateUserRequest request ) {
        User user = userService.updateName(id,request.getName());
        return UserResponse.from(user.getId(), user.getName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}

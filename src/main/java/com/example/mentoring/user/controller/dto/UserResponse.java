package com.example.mentoring.user.controller.dto;

import com.example.mentoring.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String name;

    public static UserResponse from(Long id, String name) {
        return new UserResponse(id, name);
    }
}

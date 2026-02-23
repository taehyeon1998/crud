package com.example.mentoring.user.controller.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateUserRequest {

    @NotBlank(message="이름은 필수입니다.")
    private String name;
}

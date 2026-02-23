package com.example.mentoring.user.repository;

import com.example.mentoring.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByName(String name);
}

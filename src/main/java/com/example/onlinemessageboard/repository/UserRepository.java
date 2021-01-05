package com.example.onlinemessageboard.repository;

import com.example.onlinemessageboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

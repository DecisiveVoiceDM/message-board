package com.example.onlinemessageboard.repository;

import com.example.onlinemessageboard.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

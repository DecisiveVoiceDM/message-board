package com.example.onlinemessageboard.repository;

import com.example.onlinemessageboard.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}

package com.example.onlinemessageboard.repository;

import com.example.onlinemessageboard.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}

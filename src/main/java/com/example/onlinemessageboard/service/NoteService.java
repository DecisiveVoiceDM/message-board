package com.example.onlinemessageboard.service;

import com.example.onlinemessageboard.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAll();

    Note getById(Long id);

    void create(Note note);

    void update(Long id, Note note);

    void delete(Long id);
}

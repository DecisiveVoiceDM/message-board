package com.example.onlinemessageboard.service;

import com.example.onlinemessageboard.model.Note;
import com.example.onlinemessageboard.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note getById(Long id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public void create(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void update(Long id, Note note) {
        note.setId(id);
        noteRepository.save(note);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}

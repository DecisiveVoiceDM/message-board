package com.example.onlinemessageboard.service;

import com.example.onlinemessageboard.model.Note;
import com.example.onlinemessageboard.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note getById(Long id) {
        return noteRepository.findById(id).get();
    }

    public void create(Note note) {
        noteRepository.save(note);
    }

    public void update(Long id, Note note) {
        note.setId(id);
        noteRepository.save(note);
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}

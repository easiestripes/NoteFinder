package com.austinpetrie.notefinder.dao;

import com.austinpetrie.notefinder.representations.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RegisterMapper(NoteMapper.class)
public interface NoteDB {

    @SqlUpdate("CREATE TABLE note (id INT AUTO_INCREMENT PRIMARY KEY, note_val TEXT)")
    void createNoteTable();

    /*
    public static HashMap<Integer, Note> notes = new HashMap<>();
    static {
        notes.put(1, new Note("test 1"));
        notes.put(2, new Note("test 2"));
        notes.put(3, new Note("test 3"));
    }

    public static List<Note> getNotes() {
        return new ArrayList<Note>(notes.values());
    }

    public static List<Note> getNotes(String search_val) {
        return new ArrayList<Note>(notes.values());
        // display by search_val
    }*/
}

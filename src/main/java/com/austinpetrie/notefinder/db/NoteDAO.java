package com.austinpetrie.notefinder.db;

import com.austinpetrie.notefinder.api.Note;
import com.austinpetrie.notefinder.mappers.NoteMapper;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(NoteMapper.class)
public interface NoteDAO {

    @SqlUpdate("CREATE TABLE note (id INT AUTO_INCREMENT PRIMARY KEY, note_content TEXT)")
    void createNoteTable();

    @SqlQuery("SELECT * FROM note")
    List<Note> getNotes();
}

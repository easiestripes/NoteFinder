package com.austinpetrie.notefinder.mappers;


import com.austinpetrie.notefinder.api.Note;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteMapper implements ResultSetMapper<Note> {

    public Note map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Note note = new Note();
        note.setContent(r.getString("note_content"));

        return note;
    }
}

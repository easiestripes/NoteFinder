package com.austinpetrie.notefinder.rest.controller;

import com.austinpetrie.notefinder.dao.NoteDB;
import com.austinpetrie.notefinder.representations.Note;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/notes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotesRESTController {

    private final Validator validator;
    private NoteDB note_db;

    public NotesRESTController(Validator validator, NoteDB note_db) {
        this.validator = validator;
        this.note_db = note_db;
    }

    @GET
    public Response getNotes() {
        return Response.ok(NoteDB.getNotes()).build();
    }

    @GET
    public Response getNotesByString(String search_val) {
        return Response.ok(NoteDB.getNotes(search_val)).build();
    }

    @POST
    public void saveNote(Note note) {
        /*if(note != null && note.isValid()) {

        }*/
    }
}

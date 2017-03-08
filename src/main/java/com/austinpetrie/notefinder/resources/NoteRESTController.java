package com.austinpetrie.notefinder.resources;

import com.austinpetrie.notefinder.db.NoteDAO;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.validation.Validator;

@Path("/notes")
@Produces(MediaType.APPLICATION_JSON)
public class NoteRESTController {

    //private final Validator validator;
    private NoteDAO note_db;

    public NoteRESTController(NoteDAO note_db) {
        //this.validator = validator;
        this.note_db = note_db;
    }

    @GET
    @Timed
    public Response getNotes() {
        return Response.ok(note_db.getNotes()).build();
    }

    /*@GET
    @Timed
    public Response getNotesByString(String search_val) {
        return Response.ok(note_db.getNotes(search_val)).build();
    }
    */
}

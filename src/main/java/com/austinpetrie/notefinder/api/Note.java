package com.austinpetrie.notefinder.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

public class Note {

    private long id;

    @NotBlank
    private String content;

    public Note() {
        // Jackson deserialization
    }

    public Note(String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

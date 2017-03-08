package com.austinpetrie.notefinder.representations;

import org.hibernate.validator.constraints.NotBlank;

public class Note {

    @NotBlank
    private String text;

    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

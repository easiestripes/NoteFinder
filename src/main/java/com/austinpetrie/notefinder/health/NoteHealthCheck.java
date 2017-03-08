package com.austinpetrie.notefinder.health;


import com.codahale.metrics.health.HealthCheck;

import javax.xml.transform.Result;

public class NoteHealthCheck extends HealthCheck {

    private final String temp;

    public NoteHealthCheck(String temp) {
        this.temp = temp;
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}

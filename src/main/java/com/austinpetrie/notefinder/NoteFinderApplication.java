package com.austinpetrie.notefinder;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class NoteFinderApplication extends Application<NoteFinderConfiguration> {

    public static void main(final String[] args) throws Exception {
        new NoteFinderApplication().run(args);
    }

    @Override
    public String getName() {
        return "NoteFinder";
    }

    @Override
    public void initialize(final Bootstrap<NoteFinderConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final NoteFinderConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}

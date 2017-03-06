package com.austinpetrie.notefinder;

import com.austinpetrie.notefinder.rest.controller.NotesRESTController;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.glassfish.jersey.jaxb.internal.XmlCollectionJaxbProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austinpetrie.notefinder.rest.controller.NotesRESTController;

public class NoteFinderApplication extends Application<NoteFinderConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlCollectionJaxbProvider.App.class);

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
                    final Environment env) {
        LOGGER.info("Registering REST resources");
        env.jersey().register(new NotesRESTController(env.getValidator()));
    }

}

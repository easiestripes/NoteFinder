package com.austinpetrie.notefinder;

import com.austinpetrie.notefinder.dao.NoteDB;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sun.misc.Service;

/**
 * This main-class will be used by the start_server.sh script to start the service. It can also be
 * started up in the IDE, just remember to set the correct working directory and provide the expected
 * parameters: server dw-server.yml
 */

public class NoteFinderService extends Service<NoteFinderConfiguration> {

    public static void main(String[] args) throws Exception {
        new NoteFinderService().run(args);
    }

    @Override
    public void initialize(Bootstrap<NoteFinderConfiguration> bootstrap) {
        bootstrap.setName("dw-server"); // name must match the yaml config file
    }

    @Override
    public void run(NoteFinderConfiguration conf, Environment env) throws ClassNotFoundException {
        String template = conf.getTemplate();
        String defaultName = conf.getDefaultName();

        //DBIFactory factory = new DBIFactory();
        //final DBI jdbi = factory.build(env, conf.getDatabaseConfiguration(), "postgresql");
        // using in-memory H2 database here for simplicity during development
        JdbcConnectionPool jdbcConnectionPool = JdbcConnectionPool.create("jdbc:h2:mem:test", "username", "password");
        DBI jdbi = new DBI(jdbcConnectionPool);
        NoteDB note_db = jdbi.onDemand(NoteDB.class);
        note_db.createNoteTable();
        seedTheDatabase(note_db);  // add some test data

        env.addResource(new NotesResource(note_db));
        //env.addResource(new HelloWorldResource(template, defaultName));
        env.addHealthCheck(new TemplateHealthCheck(template));
    }

}

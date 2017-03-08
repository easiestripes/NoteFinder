package com.austinpetrie.notefinder;

import com.austinpetrie.notefinder.db.NoteDAO;
import com.austinpetrie.notefinder.health.NoteHealthCheck;
import com.austinpetrie.notefinder.resources.NoteRESTController;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import java.net.UnknownHostException;

public class NoteFinderApplication extends Application<NoteFinderConfiguration> {

    public static void main(String[] args) throws Exception {
        new NoteFinderApplication().run(args);
    }

    @Override
    public String getName() {
        return "NoteFinder";
    }

    @Override
    public void initialize(Bootstrap<NoteFinderConfiguration> bootstrap) {
        bootstrap.addBundle(new DBIExceptionsBundle());
        bootstrap.addBundle(new MigrationsBundle<NoteFinderConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(NoteFinderConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.getObjectMapper().registerModule(new GuavaModule());

        // adding the webapp folder (located in our resources) as root of our webapp
        bootstrap.addBundle(new AssetsBundle("/assets", "/notebook", "index.html"));
    }

    @Override
    public void run(NoteFinderConfiguration configuration, Environment environment) throws
            UnknownHostException, ClassNotFoundException {

        final DBIFactory dbiFactory = new DBIFactory();
        final DBI jdbi = dbiFactory.build(environment, configuration.getDataSourceFactory(), "postgresql");

        NoteDAO note_db = jdbi.onDemand(NoteDAO.class);
        environment.jersey().register(new NoteRESTController(note_db));

        environment.jersey().setUrlPattern("/api/*");

        final NoteHealthCheck healthCheck = new NoteHealthCheck(configuration.getDefaultName());
        environment.healthChecks().register("NoteFinder Service", healthCheck);

    }

}

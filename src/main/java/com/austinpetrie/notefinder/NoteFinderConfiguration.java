package com.austinpetrie.notefinder;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.server.SimpleServerFactory;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class NoteFinderConfiguration extends Configuration {

    public NoteFinderConfiguration() {
        setServerFactory(new SimpleServerFactory());
    }

    @NotEmpty
    private String default_name = "NoteFinder Service";

    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();


    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.database = dataSourceFactory;
    }

    @JsonProperty
    public String getDefaultName() {
        return default_name;
    }

    @JsonProperty
    public void setDefaultName(String default_name) {
        this.default_name = default_name;
    }
}

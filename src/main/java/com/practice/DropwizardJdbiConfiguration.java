package com.practice;


import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Objects;

public class DropwizardJdbiConfiguration extends Configuration {
    // TODO: implement service configuration
    @Valid
    @NotNull
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        if(Objects.isNull(dataSourceFactory))
            dataSourceFactory=new DataSourceFactory();
        return dataSourceFactory;
    }
    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

}

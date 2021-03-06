/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DatabaseConfiguration {

    @Value("${database.isEmbedded:true}")
    Boolean databaseIsEmbedded;

    @Value("${database.url:url}")
    String databaseUrl;

    @Value("${database.username:username}")
    String databaseUsername;

    @Value("${database.password:passport}")
    String databasePassword;

    @Value("${database.script:}")
    String databaseScript;

    @Bean
    public DataSource dataSource() {
        DataSourceConfig config =
                new DataSourceConfig().withIsEmbedded(databaseIsEmbedded).withDatabaseUrl(databaseUrl)
                        .withDatabaseUsername(databaseUsername).withDatabasePassword(databasePassword);
        String[] scripts = databaseScript.split(";");
        for (String script : scripts) {
            if (!script.isEmpty()) {
                config.addHsqldbScriptList(script);
            }
        }

        return DataSourceHelper.getDataSource(config);
    }

}
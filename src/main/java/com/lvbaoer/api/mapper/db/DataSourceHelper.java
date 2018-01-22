/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper.db;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public class DataSourceHelper {

	static Logger log = LoggerFactory.getLogger(DataSourceHelper.class);

	public static DataSource getDataSource(DataSourceConfig config) {
		return mysqlDataSource(config);

	}

	private static DataSource mysqlDataSource(DataSourceConfig config) {

		PoolProperties p = new PoolProperties();
		p.setUrl(config.databaseUrl);
		p.setDriverClassName("com.mysql.jdbc.Driver");
		p.setUsername(config.databaseUsername);
		p.setPassword(config.databasePassword);
		// when database broke, reconnect
		p.setTestOnBorrow(true);
		p.setValidationQuery("SELECT 1");
		p.setValidationInterval(1000);

		p.setMaxActive(500);
		// idle connections survive 60s by default
		p.setMaxIdle(10);
		// if idle for long time, we don't keep them
		p.setMinIdle(0);
		p.setMaxWait(10000);
		// If connection is broken
		p.setLogAbandoned(true);
		p.setRemoveAbandoned(true);
		p.setRemoveAbandonedTimeout(60);
		p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
				+ "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setPoolProperties(p);
		return dataSource;
	}
}
